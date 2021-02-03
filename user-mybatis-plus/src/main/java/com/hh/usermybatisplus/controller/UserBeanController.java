package com.hh.usermybatisplus.controller;


import com.alibaba.fastjson.JSONObject;
import com.hh.usermybatisplus.pojo.UserBean;
import com.hh.usermybatisplus.service.UserBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserBeanController {

    @Autowired
    private UserBeanService userBeanService;

    @RequestMapping(value = "/mybatisplus/findUserBean",method = RequestMethod.POST)
    @ResponseBody
    public UserBean findUserBeanByMybatisPlus(@RequestBody String json) {
        try {
            JSONObject jsonObject = JSONObject.parseObject(json);
            return userBeanService.findUserBean(jsonObject.getString("id"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/mybatisplus/findUserBeanByName",method = RequestMethod.POST)
    @ResponseBody
    public List<UserBean> findUserBeanNameByMybatisPlus(@RequestBody String json) {
        try {
            JSONObject jsonObject = JSONObject.parseObject(json);
            return userBeanService.findUserBeanByName(jsonObject.getString("username"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
