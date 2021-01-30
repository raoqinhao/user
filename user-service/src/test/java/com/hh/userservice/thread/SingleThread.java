package com.hh.userservice.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThread {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        SingleThreadSub singleThreadSub = new SingleThreadSub();
        executorService.execute(singleThreadSub);
        executorService.shutdown();
        long useTime = System.currentTimeMillis() - start;
        System.out.println("--------" + useTime);
    }

}
class SingleThreadSub implements Runnable{

    private int num = 100;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (this) {
                System.out.println(num--);
            }
        }
    }

}