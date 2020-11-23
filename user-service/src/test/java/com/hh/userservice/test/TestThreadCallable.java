package com.hh.userservice.test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TestThreadCallable implements Callable {

    public static void main(String[] args) {
        TestThreadCallable testThreadCallable = new TestThreadCallable();
        FutureTask futureTask = new FutureTask<>(testThreadCallable);
        new Thread(futureTask).start();
        try {
            Object o = futureTask.get();
            System.out.println(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public Object call() throws Exception {
        String name = Thread.currentThread().getName();
        System.out.println(name);
        return "多线程处理数据成功 ：处理完成。";
    }
}
