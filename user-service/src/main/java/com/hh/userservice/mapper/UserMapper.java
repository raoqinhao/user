package com.hh.userservice.mapper;

import com.hh.userservice.pojo.UserBean;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    UserBean findUserBeanById(@Param("id") String id);
}
