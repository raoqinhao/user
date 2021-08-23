package com.hh.userservicedynamicdatasource.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName User
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/8/5 13:45
 * @Version 1.0
 **/
@Data
public class User implements Serializable {

    public static final long serialVersionUID = 1L;
    private String id;
    private String username;
    private String password;
    private String email;
    private String telephone;

}
