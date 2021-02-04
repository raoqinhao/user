package com.hh.userservicenacosprovide02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceNacosProvide02Application {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceNacosProvide02Application.class, args);
    }

}