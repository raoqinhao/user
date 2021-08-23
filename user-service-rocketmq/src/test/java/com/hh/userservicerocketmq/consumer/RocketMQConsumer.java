package com.hh.userservicerocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @ClassName RocketMQConsumer
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/6/21 15:54
 * @Version 1.0
 **/
public class RocketMQConsumer {

    public static void main(String[] args) throws Exception {
        //1、创建DefaultMQPullConsumer
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("producer_group");
        //2、设置 Namesrv地址
        consumer.setNamesrvAddr("192.168.10.55:9876");

        //设置消息拉去最大数
        consumer.setConsumeMessageBatchMaxSize(100);
        //3、设置subscribe，这里是读取的主题信息
        //参数一：消费主题
        //参数二：过滤规则
        consumer.subscribe("topic","tags");
        //创建消息监听MessageListener
        consumer.setMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                //迭代消息信息
                for (Message msg : msgs){
                    try {
                        //获取主题
                        String topic = msg.getTopic();
                        //获取标签
                        String tags = msg.getTags();

                        //获取信息
                        byte[] body = msg.getBody();
                        String result = new String(body, RemotingHelper.DEFAULT_CHARSET);

                        System.out.println("Consume消费信息——————topic:"+topic+", tags:"+tags+", result:"+result);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        //消息消费失败，重试，它还会继续消费
                        return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                    }
                }
                //消费成功
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        //开启Consumer
        consumer.start();

    }

}
