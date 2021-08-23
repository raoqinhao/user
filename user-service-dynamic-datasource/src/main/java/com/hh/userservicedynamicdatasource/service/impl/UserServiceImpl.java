package com.hh.userservicedynamicdatasource.service.impl;

import com.hh.userservicedynamicdatasource.mapper.UserMapper;
import com.hh.userservicedynamicdatasource.pojo.User;
import com.hh.userservicedynamicdatasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/8/5 16:21
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUserList() {
        return userMapper.getUserList();
    }

}
