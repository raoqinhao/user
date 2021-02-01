package com.hh.userserviceconsume.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hh.userserviceapi.pojo.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class UserController {

    @Autowired
    @Qualifier(value = "restTemplate")
    private RestTemplate restTemplate;

    private static String requestPath = "http://USER-SERVICE-PROVIDE";

    @RequestMapping(value = "/get/consume/{id}", method = RequestMethod.GET)
    @ResponseBody
    public UserBean getConsumeUserBean(@PathVariable String id) {
        return restTemplate.getForObject(requestPath + "/findUserInfo/" + id, UserBean.class);
    }

    @RequestMapping(value = "/post/consume", method = RequestMethod.POST)
    @ResponseBody
    public UserBean postConsumeUserBean(@RequestBody String json) {
        try {
            JSONObject jsonObject = JSON.parseObject(json);
            String id = jsonObject.getString("id");
            return restTemplate.getForObject(requestPath + "/findUserInfo/" + id, UserBean.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
