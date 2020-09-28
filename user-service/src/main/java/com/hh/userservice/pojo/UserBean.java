package com.hh.userservice.pojo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Set;

@Data
@Accessors(chain = true)
@Component
public class UserBean implements Serializable {
    public static final long serialVersionUID = 1L;
    private String id;
    private String username;
    private String password;
    private String email;
    private String telephone;
    private Set<Role> roles;
}
