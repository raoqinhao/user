package com.hh.userservice.test;

import com.alibaba.fastjson.JSONObject;
import com.hh.userservice.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @ClassName TestStreamAndEnum
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/5/12 10:13
 * @Version 1.0
 **/
public class TestStreamAndEnum {

    private static final Integer num = 0;

    @Test
    public void testStream() {
        Map<String, ReceiveTaskType> map = Arrays.stream(ReceiveTaskType.values()).collect(Collectors.toMap(Enum::name, Function.identity()));
        map.forEach((key,value) -> {
            System.out.println(key + " " + value);
        });
    }

    @Test
    public void str() {
        String json = "{\"username\":\"zhangsan\",\"userAge\":\"\"}";
//        User user = new User();
//        user.setUserName("zhangsan");
//        user.setUserAge(null);
//        System.out.println(user);
        User user1 = JSONObject.parseObject(json, User.class);
        System.out.println(user1);
    }

}
enum ReceiveTaskType {

}