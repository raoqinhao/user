package com.hh.userservicecloudstream.consume;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableBinding(Sink.class)
public class MsgReceive {

    @StreamListener(Sink.INPUT)
    public void receiveMsg(String msg) {
        log.info("[消息] 接收到发送消息MQ: {}", msg);
    }

}
