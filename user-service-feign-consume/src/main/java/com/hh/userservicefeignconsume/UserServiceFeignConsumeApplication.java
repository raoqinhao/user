package com.hh.userservicefeignconsume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.hh.userserviceapi.service")
@ComponentScan(basePackages = "com.hh.*")
public class UserServiceFeignConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceFeignConsumeApplication.class, args);
    }

}
