package com.hh.userserviceprovide02.service.impl;

import com.hh.userserviceprovide02.mapper.UserBeanMapper;
import com.hh.userserviceprovide02.pojo.UserBean;
import com.hh.userserviceprovide02.service.UserBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBeanServiceImpl implements UserBeanService {

    @Autowired
    private UserBeanMapper userBeanMapper;

    @Override
    public String saveUserInfo(UserBean userBean) {
        try {
            userBeanMapper.insert(userBean);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }
}
