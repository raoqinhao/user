package com.hh.userservice.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TestMulThreadCallable implements Callable {

    private static Logger logger = LoggerFactory.getLogger(TestMulThreadCallable.class);

    public static void main(String[] args) throws Exception{

        TestMulThreadCallable testMulThreadCallable = new TestMulThreadCallable();
        FutureTask futureTask = new FutureTask(testMulThreadCallable);
        new Thread(futureTask).start();
        Object o = futureTask.get();
        System.out.println(o);
    }


    @Override
    public Object call() throws Exception {
        int x = 0;
        for (int i = 0; i < 10; i++) {
            ++x;
            logger.info("当前线程名称：{}, 执行数：{}",Thread.currentThread().getName(), i);
        }
        return x;
    }
}
