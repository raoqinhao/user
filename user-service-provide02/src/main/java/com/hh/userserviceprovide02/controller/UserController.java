package com.hh.userserviceprovide02.controller;

import com.hh.userserviceprovide02.pojo.UserBean;
import com.hh.userserviceprovide02.service.UserBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Controller
public class UserController {

    @Autowired
    private UserBeanService userBeanService;

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(value = "/findUserInfo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public UserBean getUserInfo(@PathVariable("id") String id) {
        return new UserBean(id,"provide02","123456","976869901","17879303721");
    }

    @RequestMapping(value = "/saveUserInfo", method = RequestMethod.POST)
    @ResponseBody
    public String saveUserInfo(@RequestBody UserBean userBean) {
        return userBeanService.saveUserInfo(userBean);
    }

    @RequestMapping(value = "saveUserInfoAndSaveRemoteInfo",method = RequestMethod.POST)
    public String saveUserInfoAndSaveRemoteInfo(@RequestBody UserBean userBean) {
        try {
            String saveUserInfo = userBeanService.saveUserInfo(userBean);
            userBean.setId(UUID.randomUUID().toString().replaceAll("-",""));
            userBean.setUsername(userBean.getUsername() + "r");
            String remoteStatus = restTemplate.postForObject("http://localhost:8087/mybatisplus/saveUserBean", userBean, String.class);
            System.out.println(remoteStatus);
            return saveUserInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

}
