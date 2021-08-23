package com.hh.userservice.service.impl;

import com.hh.userservice.mapper.UserBeanMapper;
import com.hh.userservice.mapper.UserMapper;
import com.hh.userservice.model.UserBeanExample;
import com.hh.userservice.pojo.UserBean;
import com.hh.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserBeanMapper userBeanMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserBean> findAllUserBean() {
        UserBean userBean = new UserBean();

        return null;
    }

    @Override
    public UserBean findUserBeanByUserBeanName(String username) {
        UserBean userBean = userMapper.findUserBeanByUserName(username);
        return userBean;
    }

    @Override
    public List<com.hh.userservice.model.UserBean> findUserById(String id) {
        UserBeanExample userBeanExample = new UserBeanExample();
        UserBeanExample.Criteria criteria = userBeanExample.createCriteria();
        criteria.andIdEqualTo(id);
        com.hh.userservice.model.UserBean userBean = userBeanMapper.selectByPrimaryKey(id);
        List<com.hh.userservice.model.UserBean> userBeans = userBeanMapper.selectByExample(userBeanExample);
        return userBeans;
    }

    @Override
    public UserBean findUserBeanById(String id) {
        return userMapper.findUserBeanById(id);
    }

    @Override
    public void insertUesrData() {
        long start = System.currentTimeMillis();
//        CompletableFuture.runAsync(() -> {
//            userMapper.insertUserBeanData(new UserBean(UUID.randomUUID().toString().replaceAll("-","")
//            ,"ZHANG","123","976869901@qq.com","17879303721"));
//        });
        System.out.println(System.currentTimeMillis() - start);
    }
}
