package com.hh.userserviceribbonhystrixconsume;

import com.hh.userserviceribbonhystrixconsume.config.ConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrix
@RibbonClient(name = "USER-SERVICE-PROVIDE",configuration = ConfigProperties.class)
@EnableHystrixDashboard
public class UserServiceRibbonHystrixConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceRibbonHystrixConsumeApplication.class, args);
    }

}
