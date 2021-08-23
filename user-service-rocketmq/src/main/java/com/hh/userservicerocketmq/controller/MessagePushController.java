package com.hh.userservicerocketmq.controller;


import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MessagePushController
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/6/21 16:08
 * @Version 1.0
 **/
@RestController
@RequestMapping("/mq")
public class MessagePushController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/push/message")
    public String pushMessage() {
        try {
            rocketMQTemplate.convertAndSend("topic_park:tag", "{\"name\",\"zhangsan\"}");
            return "发送成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "发送失败";
    }

}
