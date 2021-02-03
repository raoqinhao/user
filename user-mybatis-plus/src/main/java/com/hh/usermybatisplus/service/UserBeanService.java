package com.hh.usermybatisplus.service;

import com.hh.usermybatisplus.pojo.UserBean;

import java.util.List;

public interface UserBeanService {
    UserBean findUserBean(String id);

    List<UserBean> findUserBeanByName(String username);
}

