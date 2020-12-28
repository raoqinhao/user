package com.hh.userserviceapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserBean implements Serializable {
    public static final long serialVersionUID = 1L;
    private String id;
    private String username;
    private String password;
    private String email;
    private String telephone;
}
