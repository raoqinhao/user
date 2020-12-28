package com.hh.usereureka02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class UserEureka02Application {

    public static void main(String[] args) {
        SpringApplication.run(UserEureka02Application.class, args);
    }

}
