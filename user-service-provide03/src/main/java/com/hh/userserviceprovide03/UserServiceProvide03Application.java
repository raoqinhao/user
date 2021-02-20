package com.hh.userserviceprovide03;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.hh.userserviceprovide03.mapper")
public class UserServiceProvide03Application {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceProvide03Application.class, args);
    }

}
