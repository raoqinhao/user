package com.hh.userservicedynamicdatasource.mapper;

import com.hh.userservicedynamicdatasource.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/8/5 14:09
 * @Version 1.0
 **/
@Repository
public interface UserMapper {

    List<User> getUserList();

}
