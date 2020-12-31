package com.hh.userserviceribbonhystrixconsume.controller;


import com.hh.userserviceapi.pojo.UserBean;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class UserController {

    @Autowired
    @Qualifier(value = "restTemplate")
    private RestTemplate restTemplate;

    private static String requestPath = "http://USER-SERVICE-PROVIDE";

    @HystrixCommand(fallbackMethod = "getDefaultInfo")
    @RequestMapping(value = "/hystrix/consume/{id}", method = RequestMethod.GET)
    @ResponseBody
    public UserBean getConsumeUserBean(@PathVariable String id) {
        return restTemplate.getForObject(requestPath + "/findUserInfo/" + id, UserBean.class);
    }


    public UserBean getDefaultInfo(@PathVariable String id) {
        return new UserBean(id,"暂无数据",null,null,null);
    }

}
