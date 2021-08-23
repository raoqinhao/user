package com.hh.userservicedynamicdatasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hh.userservicedynamicdatasource.mapper")
public class UserServiceDynamicDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceDynamicDatasourceApplication.class, args);
    }

}
