package com.hh.userservicerocketmq.listen;

import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName RocketMQListener
 * @Deacription TODO
 * @Author author
 * @Date 2021/6/21 17:15
 * @Version 1.0
 **/
@Component
@RocketMQMessageListener(topic = "topic_park", selectorExpression = "tag", consumerGroup = "producer_group", consumeMode = ConsumeMode.CONCURRENTLY)
public class TestRocketMQListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        System.out.println("RocketMQ收到消息：" + message);
    }

}
