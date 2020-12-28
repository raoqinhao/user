package com.hh.usereureka01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class UserEureka01Application {

    public static void main(String[] args) {
        SpringApplication.run(UserEureka01Application.class, args);
    }

}
