package com.hh.userservice.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 测试缓存线程池的使用案例
 **/
public class TestNewCachedThreadPool {

    public static void main(String[] args) throws Exception{

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            Future<?> submitFuture = executorService.submit(() -> {
                return Thread.currentThread().getName() + "执行成功！！！";
            });
            Object o = submitFuture.get();
            System.out.println(o);
        }
        executorService.shutdown();
    }

}
