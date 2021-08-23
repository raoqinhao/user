package com.hh.userservice.test;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName TestAtomic
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/6/16 15:18
 * @Version 1.0
 **/
public class TestAtomic {

    @Test
    public void testAtomicInteger() {
        AtomicInteger atomicInteger = new AtomicInteger();
        int i = atomicInteger.incrementAndGet();
        int j = atomicInteger.incrementAndGet();
        int k = atomicInteger.incrementAndGet();
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
        int l = atomicInteger.getAndIncrement();
        System.out.println(l);
        int m = atomicInteger.getAndIncrement();
        System.out.println(m);

    }

}
