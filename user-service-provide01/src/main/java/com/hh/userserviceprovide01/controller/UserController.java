package com.hh.userserviceprovide01.controller;

import com.hh.userserviceprovide01.pojo.UserBean;
import com.hh.userserviceprovide01.service.UserBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserBeanService userBeanService;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/findUserInfo/{id}", method = RequestMethod.GET)
    public UserBean getUserInfo(@PathVariable("id") String id) {
        return new UserBean(id,"provide01","123456","976869901","17879303721");
    }

    @RequestMapping(value = "/saveUserInfo", method = RequestMethod.POST)
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
