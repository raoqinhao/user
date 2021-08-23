package com.hh.userservice.test;

import com.alibaba.fastjson.JSONArray;
import org.junit.Test;

import java.util.StringJoiner;

/**
 * @ClassName TestStringJoiner
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/8/20 9:31
 * @Version 1.0
 **/
public class TestStringJoiner {

    @Test
    public void testStr() {
        StringJoiner joiner = new StringJoiner(",","[","]");
        joiner.add("1");
        joiner.add("2");
        joiner.add("3");
        System.out.println(joiner.toString());
        System.out.println("---------------");
        JSONArray jsonArray = JSONArray.parseArray(joiner.toString());
        for (int i = 0; i < jsonArray.size(); i++) {
            System.out.println(jsonArray.getString(i));
        }
    }

}
