package com.hh.userservice.service;

import com.hh.userservice.pojo.UserBean;

import java.util.List;

public interface UserService {
    List<UserBean> findAllUserBean();

    UserBean findUserBeanByUserBeanName(String username);

    List<com.hh.userservice.model.UserBean> findUserById(String id);

    UserBean findUserBeanById(String id);
}
