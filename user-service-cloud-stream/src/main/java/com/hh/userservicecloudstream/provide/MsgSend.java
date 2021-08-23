package com.hh.userservicecloudstream.provide;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
@EnableBinding({Source.class})
public class MsgSend {

    @Resource
    public Source source;

    public boolean sendMsg(String msg) {
        log.info("MQ开始发送数据：" + msg);
        return source.output().send(MessageBuilder.withPayload(msg).build());
    }

}
