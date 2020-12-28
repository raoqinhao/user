package com.hh.userserviceprovide02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserServiceProvide02Application {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceProvide02Application.class, args);
    }

}
