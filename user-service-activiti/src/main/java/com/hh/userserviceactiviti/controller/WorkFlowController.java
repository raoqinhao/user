package com.hh.userserviceactiviti.controller;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName WorkFlowController
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/4/9 14:09
 * @Version 1.0
 **/
@Controller
public class WorkFlowController {

    @Autowired
    @Qualifier("buildProcessEngine")
    private ProcessEngine processEngine;

    @GetMapping("/activiti/start")
    @ResponseBody
    public void activitiStartWorkFlow() {
        Deployment easyWorkFlowDeployment = processEngine.getRepositoryService().createDeployment().name("简易请假流程")
                .addClasspathResource("easyworkflow.bpmn")
                .addClasspathResource("easyworkflow.png")
                .deploy();
        System.out.println("开启流程定义 流程主键：" + easyWorkFlowDeployment.getId() + "，流程名称：" + easyWorkFlowDeployment.getName());
    }

    @GetMapping("/activiti/runtime")
    @ResponseBody
    public void activityRuntime() {
        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey("easyworkflow");
        System.out.println("开始流程实例：" + processInstance.getName() + ", 流程实例id：" + processInstance.getId() + ", 开始实例用户的ID：" + processInstance.getStartUserId());
    }

    @GetMapping("/activiti/getTask/{name}")
    @ResponseBody
    public String activitiGetTask(@PathVariable String name) {
        List<Task> list = processEngine.getTaskService().createTaskQuery().taskAssignee(name).list();
        return list.toString();
    }

    @GetMapping("/activiti/execution/task/{taskId}")
    @ResponseBody
    public String activitiExecutionTask(@PathVariable String taskId) {
        try {
            processEngine.getTaskService().complete(taskId);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }


    @GetMapping("/activiti/viewImage")
    @ResponseBody
    public void activitiViewImage() throws Exception {
        String deploymentId = "1";
        List<String> deploymentResourceNames = processEngine.getRepositoryService().getDeploymentResourceNames(deploymentId);
        String imageName = "";
        for (int i = 0; i < deploymentResourceNames.size(); i++) {
            System.out.println("name: " + deploymentResourceNames.get(i));
            if (deploymentResourceNames.indexOf(".png") >= 0) {
                imageName = deploymentResourceNames.get(i);
            }
        }
        if (StringUtils.isNotBlank(imageName)) {
            File file = new File("D:\\project\\user\\user-service-activiti\\" + imageName);
            InputStream resourceAsStream = processEngine.getRepositoryService().getResourceAsStream(deploymentId, imageName);
            FileUtils.copyInputStreamToFile(resourceAsStream,file);
        }
    }

}
