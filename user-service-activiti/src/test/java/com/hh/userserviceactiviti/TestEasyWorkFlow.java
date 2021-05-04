package com.hh.userserviceactiviti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName TestEasyWorkFlow
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/4/10 16:41
 * @Version 1.0
 **/
@SpringBootTest
public class TestEasyWorkFlow {

    @Autowired
    @Qualifier("buildProcessEngine")
    private ProcessEngine processEngine;

    @Test
    public void deploy() throws Exception {
        Deployment easyWorkFlowDeployment = processEngine.getRepositoryService().createDeployment().name("简易请假流程").addClasspathResource("classpath://easyworkflow.bpmn").deploy();
        System.out.println("流程主键：" + easyWorkFlowDeployment.getId() + "，流程名称：" + easyWorkFlowDeployment.getName());
    }

}
