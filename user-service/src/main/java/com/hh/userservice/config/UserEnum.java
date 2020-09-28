package com.hh.userservice.config;

public enum UserEnum {

    USERNAME("ZHONG"),PASSWORD("123456"),AGE("100");

    String name;

    UserEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
