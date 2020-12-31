package com.hh.userserviceprovide01.controller;

import com.hh.userserviceapi.pojo.UserBean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "/findUserInfo/{id}", method = RequestMethod.GET)
    public UserBean getUserInfo(@PathVariable("id") String id) {
        return new UserBean(id,"provide01","123456","976869901","17879303721");
    }


}