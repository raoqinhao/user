package com.hh.userserviceprovide02.controller;

import com.hh.userserviceprovide02.pojo.UserBean;
import com.hh.userserviceprovide02.service.UserBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserBeanService userBeanService;


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

}
