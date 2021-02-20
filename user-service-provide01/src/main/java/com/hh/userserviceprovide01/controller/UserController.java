package com.hh.userserviceprovide01.controller;

import com.hh.userserviceprovide01.model.UserBean;
import com.hh.userserviceprovide01.service.UserBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserBeanService userBeanService;

    @RequestMapping(value = "/findUserInfo/{id}", method = RequestMethod.GET)
    public UserBean getUserInfo(@PathVariable("id") String id) {
        return new UserBean(id,"provide01","123456","976869901","17879303721");
    }

    @RequestMapping(value = "/saveUserInfo", method = RequestMethod.POST)
    public String saveUserInfo(@RequestBody UserBean userBean) {
        return userBeanService.saveUserInfo(userBean);
    }

}
