package com.hh.userservice.thread;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.*;

@Slf4j
public class ThreadPool {

    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        FixedThreadTest fixedThreadTest1 = new FixedThreadTest();
//
//        executorService.execute(fixedThreadTest1);
//        executorService.execute(fixedThreadTest1);
//        executorService.execute(fixedThreadTest1);
//        executorService.execute(fixedThreadTest1);
//        executorService.execute(fixedThreadTest1);

        ExecutorService customExecutorService = new ThreadPoolExecutor(2,2,1, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(3),new ThreadPoolExecutor.AbortPolicy());
        FixedThreadTest fixedThreadTest = new FixedThreadTest();
//        for (int i = 0; i < 1000; i++) {
            customExecutorService.execute(fixedThreadTest);
            customExecutorService.execute(fixedThreadTest);
//        }
        customExecutorService.shutdown();


//        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>(10);
//        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,5,TimeUnit.SECONDS,workQueue,handler);
//        for(int i=0; i<100; i++) {
//            try {
//                executor.execute(new Thread(() -> log.info(Thread.currentThread().getName() + " is running")));
//            } catch (Exception e) {
//                e.printStackTrace();
//                log.error(e.getMessage());
//            }
//        }
//        executor.shutdown();

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