package com.hh.userservicejimureport.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @ClassName JimuQueryController
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/4/19 9:10
 * @Version 1.0
 **/
@Controller
public class JimuQueryController {

    @GetMapping("/user/data")
    @ResponseBody
    public String getUserData() {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("username","zhangsan");
        jsonObject1.put("password","123");
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("username","lisi");
        jsonObject2.put("password","123456");
        jsonArray.add(jsonObject1);
        jsonArray.add(jsonObject2);
        jsonObject.put("data",jsonArray);
        return jsonObject.toJSONString();
    }

}
