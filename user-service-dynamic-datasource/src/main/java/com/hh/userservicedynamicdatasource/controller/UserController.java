package com.hh.userservicedynamicdatasource.controller;

import com.hh.userservicedynamicdatasource.pojo.User;
import com.hh.userservicedynamicdatasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName UserController
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/8/5 16:45
 * @Version 1.0
 **/
@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("getUserList")
    public List<User> getUserList() {
        return userService.getUserList();
    }

}
