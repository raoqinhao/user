package com.hh.userserviceprovide01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.hh.userserviceprovide01.mapper")
public class UserServiceProvide01Application {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceProvide01Application.class, args);
    }

}
