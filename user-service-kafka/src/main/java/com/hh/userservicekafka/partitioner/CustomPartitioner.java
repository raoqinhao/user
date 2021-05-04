package com.hh.userservicekafka.partitioner;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Random;

/**
 * @ClassName CustomPartitioner
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/4/2 17:20
 * @Version 1.0
 **/
@Component
public class CustomPartitioner implements Partitioner {
    @Override
    public int partition(String s, Object o, byte[] bytes, Object o1, byte[] bytes1, Cluster cluster) {
        if ((new Random().nextInt() * 100) % 2 == 0)
            return 1;
        return 0;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
