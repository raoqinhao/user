package com.hh.userserviceprovide01.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBean {

    private String id;
    private String username;
    private String password;
    private String email;
    private String telephone;

}
