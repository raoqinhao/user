package com.hh.userservice.mapper;

import com.hh.userservice.pojo.User;
import com.hh.userservice.pojo.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    UserBean findUserBeanById(@Param("id") String id);

    UserBean findUserBeanByUserName(@Param("username") String username);

    void insertUserBeanData(UserBean userBean);

    void insertUserData(@Param("userList") List<User> userList);
}
