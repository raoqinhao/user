package com.hh.userservice.test;

import com.hh.userservice.User;

public class TestClone {

    public static void main(String[] args) {
        User user = new User();
        user.setUserAge(10);
        user.setUserName("张");
        System.out.println(user);
        Object clone = user.clone();
        System.out.println(clone);
        System.out.println(Thread.currentThread().getName());
    }

}
