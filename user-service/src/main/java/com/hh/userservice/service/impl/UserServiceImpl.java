package com.hh.userservice.service.impl;

import com.hh.userservice.pojo.UserBean;
import com.hh.userservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<UserBean> findAllUserBean() {
        UserBean userBean = new UserBean();

        return null;
    }

    @Override
    public UserBean findUserBeanByUserBeanName(String username) {
        UserBean userBean = new UserBean();
        userBean.setId(UUID.randomUUID().toString().replaceAll("-",""));
        userBean.setUsername("admin");
        userBean.setPassword("123456");
        userBean.setEmail("976869901@qq.com");
        userBean.setTelephone("17879303721");
        return userBean;
    }
}
