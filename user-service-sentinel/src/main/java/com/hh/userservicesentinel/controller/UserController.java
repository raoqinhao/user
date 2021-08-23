package com.hh.userservicesentinel.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/6/25 15:50
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/get/info")
    public String getInfo() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","zhangsan");
        jsonObject.put("age","12");
        return jsonObject.toJSONString();
    }

    @RequestMapping("/get/address")
    public String getAddress() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","zhangsan");
        jsonObject.put("address","上海市浦东新区陆家嘴街道");
        return jsonObject.toJSONString();
    }
}
