package com.hh.userservice.test;

import com.hh.userservice.User;
import org.apache.ibatis.io.Resources;
import org.junit.Test;
import org.thymeleaf.util.StringUtils;

import java.io.File;
import java.util.*;
import java.util.regex.Pattern;

public class TestObjects {


    @Test
    public void testStringFormat() throws Exception {
        String format = String.format("{\"code\":\"%s\",\"message\":\"%s\"}", 1, 1);
        System.out.println(format);
        File resourceAsFile = Resources.getResourceAsFile("templates/index.html");
        System.out.println(resourceAsFile);
    }

    @Test
    public void testMatcher() {
        Pattern compile = Pattern.compile("[0-9]*");
        if (compile.matcher("12888885").matches()) {
            System.out.println("is a number");
        } else {
            System.out.println("no is a number");
        }
    }

    @Test
    public void testObjects() {
        List<User> userList = new ArrayList<>();
        List<User> list = new ArrayList<>();
        list.add(new User("zhangsan",12));
        list.add(new User("zhangsan",18));

        if (!Objects.isNull(userList)) {
            User user = list.get(0);
            System.out.println(user);
        }
    }

    @Test
    public void testStringLength() {
        String strLength = "91310120752458794E";
        System.out.println(strLength.length());
    }

    @Test
    public void testFileStyle() {

        String fileName = "a.xlsx";
        Boolean xlsx = StringUtils.endsWith(fileName, "xlsx");
        System.out.println(xlsx);

        String fileName2 = "a.xls";
        Boolean xls = StringUtils.endsWith(fileName2, "xls");
        System.out.println(xls);


    }


    @Test
    public void ObjectHash() {
        int[] arr = new int[10];
        int i1 = Objects.hashCode("1");
        arr[i1 % 10] = i1;
        System.out.println(i1);
        int i2 = Objects.hashCode("2");
        arr[i2 % 10] = i2;
        System.out.println(i2);
        int i3 = Objects.hashCode("3");
        arr[i3 % 10] = i3;
        System.out.println(i3);
        int i4 = Objects.hashCode("4");
        arr[i4 % 10] = i4;
        System.out.println(i4);
        System.out.println("--------");
        for (int i = 0; i < arr.length; i++) {
            int i5 = arr[i];
            System.out.println(i5);
        }
    }

}
