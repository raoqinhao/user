package com.hh.userservice.test;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName TestGuava
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/6/23 9:23
 * @Version 1.0
 **/
public class TestGuava {

    @Test
    public void testRateLimiter() throws Exception{
        RateLimiter rateLimiter = RateLimiter.create(1.0);
        for (int i = 0; i < 100; i++) {
//            rateLimiter.acquire(); // 获取令牌，会进行阻塞。
            long time = (long) (Math.random() * 3000);
            boolean b = rateLimiter.tryAcquire(time, TimeUnit.MILLISECONDS);
            if (b) {
                System.out.println(i);
            } else {
                System.out.println("未获取到令牌");
            }
        }
    }

    @Test
    public void testBloomFilter() {
        BloomFilter<Integer> integerBloomFilter = BloomFilter.create(Funnels.integerFunnel(), 100, 0.02);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            integerBloomFilter.put(i);
            list.add(i);
        }

        for (int i = 0; i < 10; i++) {
            if (integerBloomFilter.mightContain(i)) {
                System.out.println(list.get(i));
            } else {
                System.out.println("过滤器中未查找到数据");
            }
        }

    }
}
