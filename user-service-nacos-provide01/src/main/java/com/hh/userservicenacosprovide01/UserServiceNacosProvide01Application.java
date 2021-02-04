package com.hh.userservicenacosprovide01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceNacosProvide01Application {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceNacosProvide01Application.class, args);
    }

}
