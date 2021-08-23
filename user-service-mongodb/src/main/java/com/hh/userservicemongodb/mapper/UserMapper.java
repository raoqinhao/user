package com.hh.userservicemongodb.mapper;

import com.hh.userservicemongodb.pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserMapper
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/6/18 14:25
 * @Version 1.0
 **/
@Repository
public interface UserMapper extends MongoRepository<User,String> {
}
