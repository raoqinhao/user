package com.hh.userservicekafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping("/topic")
    @ResponseBody
    public String sendMessage(@RequestBody String message) {
        kafkaTemplate.send("topicPark", message);
        return "ok";
    }

    @PostMapping("/default")
    @ResponseBody
    public String sendDefault(@RequestBody String message) {
        kafkaTemplate.sendDefault("key",message);
        return "ok";
    }

}
