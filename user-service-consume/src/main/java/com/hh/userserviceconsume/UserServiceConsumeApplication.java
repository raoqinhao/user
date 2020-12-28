package com.hh.userserviceconsume;

import com.hh.userserviceconsume.config.ConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@RibbonClient(name = "USER-SERVICE-PROVIDE",configuration = ConfigProperties.class)
@EnableEurekaClient
@EnableDiscoveryClient
public class UserServiceConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceConsumeApplication.class, args);
    }

}
