package com.hh.userservice.test;


import org.junit.Test;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

// 测试互斥锁入门案例
public class TestAQSLock extends AbstractQueuedSynchronizer {

    @Override
    protected boolean tryAcquire(int arg) {
        return compareAndSetState(100,111);
//        return super.tryAcquire(arg);
    }

    @Override
    protected boolean tryRelease(int arg) {
        return compareAndSetState(200,555);
//        return super.tryRelease(arg);
    }

    private int num = 0;

    @Test
    public void tryGetLock() throws Exception{
        TestAQSLock lock = new TestAQSLock();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                lock.tryAcquire(1000);
                num++;
                lock.tryRelease(2000);
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(num);
    }

}
