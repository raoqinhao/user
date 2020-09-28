package com.hh.userservice.test;

import org.junit.Test;

public class TestMatcher {



    @Test
    public void testMatcher() {
        String match = "D";
        boolean boo = match.matches("^[A|B|C|D]$");
        System.out.println(boo);
        String num = "11";
        boolean booNum = num.matches("^\\+?[1-9]\\d*$");
        System.out.println(booNum);

    }


    @Test
    public void testNumber() {
        int a = 1;
        String b = "1";
        String c = "张三";
        System.out.println(b == "1");
        System.out.println(c == "张三");
        System.out.println(c.equals("张三"));
    }

}
