package com.hh.userservice.pojo;

import com.hh.userservice.handle.ExampleTypeHandle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.annotation.ColumnType;

import java.io.Serializable;
import java.util.Set;

@Data
@Accessors(chain = true)
@Component
@NoArgsConstructor
@AllArgsConstructor
public class UserBean implements Serializable {
    public static final long serialVersionUID = 1L;
    private String id;
    @ColumnType(jdbcType = JdbcType.VARCHAR, typeHandler = ExampleTypeHandle.class)
    private String username;
    private String password;
    private String email;
    private String telephone;
//    private Set<Role> roles;
}
