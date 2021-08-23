package com.hh.userservicerocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @ClassName RocketMQProducer
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/6/21 10:21
 * @Version 1.0
 **/
public class RocketMQProducer {

    public static void main(String[] args) throws Exception{

        //1、创建DefaultMQProducer
        DefaultMQProducer producer = new DefaultMQProducer("producer_group") ;
        //2、设置 Namesrv地址
        producer.setNamesrvAddr("192.168.10.55:9876");
        producer.setVipChannelEnabled(false);
        //3、开启DefaultMQProducer 使用public Message(String topic, String tags, String keys, byte[] body) 构造函数
        producer.start();
        //4、创建消息Message
        //设置主题
        Message message = new Message("topic",
                //主题
                "tags",
                //消息唯一值
                "keys",
                //内容
                "hello world".getBytes(RemotingHelper.DEFAULT_CHARSET)
        );
        //5、发送消息
        SendResult result = producer.send(message);
        System.out.println(result);
        //6、关闭DefaultMQProducer
        producer.shutdown();

    }

}
