package com.hh.userservicekafka.listen;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsume {

    @KafkaListener(topics = {"topicPark"})
    public void getMessage1(ConsumerRecord<String, Object> record) {
        System.out.println("消费者1：主题：" + record.topic() + "，分区：" + record.partition() + "，消息体：" + record.value());
    }

    @KafkaListener(topics = {"topicPark"})
    public void getMessage2(ConsumerRecord<String, Object> record) {
        System.out.println("消费者2：主题：" + record.topic() + "，分区：" + record.partition() + "，消息体：" + record.value());
    }

}
