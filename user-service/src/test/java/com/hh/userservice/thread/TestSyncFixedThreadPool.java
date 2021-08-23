package com.hh.userservice.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @ClassName TestSyncFixedThreadPool
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/4/15 15:34
 * @Version 1.0
 **/
@Slf4j
public class TestSyncFixedThreadPool {

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Callable<String> task1 = () -> "task 1";
        Callable<String> task2 = () -> "task 2";
        Callable<String> task3 = () -> "task 3";
        Callable<String> task4 = () -> "task 4";

        System.out.println(task1.call());
        System.out.println(task2.call());
        System.out.println(task3.call());
        System.out.println(task4.call());

        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(task1, task2, task3, task4));
        futures.stream().forEach(s -> {
            try {
                log.info(Thread.currentThread() + s.get());
                System.out.println(s.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
    }

}
