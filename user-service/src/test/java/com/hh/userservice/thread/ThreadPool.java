package com.hh.userservice.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        FixedThreadTest fixedThreadTest1 = new FixedThreadTest();

        executorService.execute(fixedThreadTest1);
        executorService.execute(fixedThreadTest1);
        executorService.execute(fixedThreadTest1);
        executorService.execute(fixedThreadTest1);
        executorService.execute(fixedThreadTest1);
    }

}


class FixedThreadTest extends Thread{
    private int num = 1000;
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (this) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (num < 0) break;
                System.out.println(Thread.currentThread().getName() + " - " + num);
                num--;
            }
        }
    }
}