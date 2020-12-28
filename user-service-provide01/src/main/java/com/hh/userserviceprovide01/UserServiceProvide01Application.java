package com.hh.userserviceprovide01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserServiceProvide01Application {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceProvide01Application.class, args);
    }

}
