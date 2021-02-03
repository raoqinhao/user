package com.hh.usermybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@Component
@NoArgsConstructor
@AllArgsConstructor
@TableName("u_user")
public class UserBean implements Serializable {
    public static final long serialVersionUID = 1L;
    private String id;
    private String username;
    private String password;
    private String email;
    private String telephone;
}
