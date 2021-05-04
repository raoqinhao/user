package com.hh.userservicekafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName KafkaConfiguration
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/4/6 9:07
 * @Version 1.0
 **/
@Configuration
public class KafkaConfiguration {

    @Bean
    public NewTopic newTopic() {
        return new NewTopic("partTopic",3, (short) 0);
    }

}
