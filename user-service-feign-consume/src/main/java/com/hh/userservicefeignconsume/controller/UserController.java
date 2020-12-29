package com.hh.userservicefeignconsume.controller;

import com.hh.userserviceapi.pojo.UserBean;
import com.hh.userserviceapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/feign/consume/{id}",method = RequestMethod.GET)
    @ResponseBody
    public UserBean getUserBean(@PathVariable String id) {
        return userService.findUserInfo(id);
    }


}
