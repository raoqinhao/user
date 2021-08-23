package com.hh.userservicejimureport;

import com.hh.userservicejimureport.config.JimuReportTokenService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = {"org.jeecg.modules.jmreport","com.hh.userservicejimureport"})
//@ComponentScan("org.jeecg.modules.jmreport")
//@ComponentScan("com.hh.userservicejimureport")
@Import({JimuReportTokenService.class})
public class UserServiceJimureportApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceJimureportApplication.class, args);
    }

}
