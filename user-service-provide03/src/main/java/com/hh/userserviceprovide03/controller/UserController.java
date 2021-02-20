package com.hh.userserviceprovide03.controller;

import com.hh.userserviceprovide03.pojo.UserBean;
import com.hh.userserviceprovide03.service.UserBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserBeanService userBeanService;

    @RequestMapping(value = "/findUserInfo/{id}", method = RequestMethod.GET)
    public UserBean getUserInfo(@PathVariable("id") String id) {
        return new UserBean(id,"provide03","123456","976869901","17879303721");
    }

    @RequestMapping(value = "/saveUserInfo", method = RequestMethod.POST)
    public String saveUserInfo(@RequestBody UserBean userBean) {
        return userBeanService.saveUserInfo(userBean);
    }

}
