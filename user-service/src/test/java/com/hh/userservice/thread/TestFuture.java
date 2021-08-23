package com.hh.userservice.thread;


import cn.hutool.core.util.PageUtil;
import com.alibaba.fastjson.JSONObject;
import com.hh.userservice.mapper.UserMapper;
import com.hh.userservice.pojo.UserBean;
import com.hh.userservice.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.TRANSACTION_MODE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestFuture {

    private Logger logger = LoggerFactory.getLogger(TestFuture.class);

//    @Autowired
    private UserService userService;

//    @Autowired
    private UserMapper userMapper;

    @Test
    public void testOf() throws Exception{
        CompletableFuture<String> oneFuture = CompletableFuture.supplyAsync(() -> {
            logger.info("当前线程对象1 {}", Thread.currentThread().getName());
            try {
                Thread.sleep(10000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "ok1";
        });
        CompletableFuture<String> twoFuture = CompletableFuture.supplyAsync(() -> {
            logger.info("当前线程对象2 {}", Thread.currentThread().getName());
            return "ok2";
        });
        CompletableFuture<String> threeFuture = CompletableFuture.supplyAsync(() -> {
            logger.info("当前线程对象3 {}", Thread.currentThread().getName());
            try {
                Thread.sleep(10000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "ok3";
        });
        System.out.println("-------------");
        // 并不需要所有的future执行成功，任意一个执行完成就直接返回第一个future返回的结果。
        CompletableFuture<Object> anyCompletableFuture = CompletableFuture.anyOf(oneFuture, twoFuture, threeFuture);
        System.out.println(anyCompletableFuture.get());
        System.out.println("-------------");
        // 需要所有的future执行结束以后，才会完成，否则会一直阻塞直到所有的future执行完成。
        CompletableFuture<Void> allCompletableFuture = CompletableFuture.allOf(oneFuture, twoFuture, threeFuture);
        System.out.println(allCompletableFuture.get());
    }

    @Test
    public void testThenApply() throws Exception{
        // 通过thenApplyAsync/thenApply 方法会为我们创建一个新的future对象。
        CompletableFuture<Boolean> booleanCompletableFuture = CompletableFuture.supplyAsync(() -> {
            logger.info("当前线程对象 {}", Thread.currentThread().getName());
            return "ok1";
        }).thenApplyAsync((response) -> {
            if ("ok".equals(response)) {
                logger.info("响应结果正常 {}", response);
                return true;
            } else {
                logger.info("响应结果异常 {}", response);
                return false;
            }
        });
        System.out.println(booleanCompletableFuture.get());
    }



    @Test
    public void testAsyncGetNowMethod() {
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            logger.info("测试有参异步方法 {}", Thread.currentThread().getName());
            return "ok";
        });
        try {
            Thread.sleep(1000);
            String now = stringCompletableFuture.getNow("fail");
            System.out.println(now);
//            stringCompletableFuture.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAsyncGetTimeMethod() {
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            logger.info("测试有参异步方法 {}", Thread.currentThread().getName());
            return "ok";
        });
        try {
            String join = stringCompletableFuture.get(10000, TimeUnit.NANOSECONDS);
            System.out.println(join);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAsyncJoinMethod() {
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            logger.info("测试有参异步方法 {}", Thread.currentThread().getName());
            return "ok";
        });
        String join = stringCompletableFuture.join();
        System.out.println(join);
    }

    @Test
    public void testAsyncObjectThread() throws Exception{
        logger.info("主线程开始执行任务 {}", Thread.currentThread().getName());
        CompletableFuture<Boolean> booleanCompletableFuture = CompletableFuture.supplyAsync(() -> {
            logger.info("测试有参异步方法 {}", Thread.currentThread().getName());
            return true;
        }).handle((response, e) -> {
            logger.info("测试有参异步方法返回结果 {}", response);
            logger.info("测试有参异步方法异常结果 {}", e);
            return response;
        }).handleAsync((response, e) -> {
            logger.info("测试有参异步方法返回结果 {}", response);
            logger.info("测试有参异步方法异常结果 {}", e);
            return response;
        });
        System.out.println(booleanCompletableFuture.get());
        System.out.println("--------------");
        CompletableFuture<Boolean> booleanCompletableFuture1 = CompletableFuture.supplyAsync(() -> {
            logger.info("测试有参异步方法 {}", Thread.currentThread().getName());
            return true;
        }).handle((response, e) -> {
            logger.info("测试有参异步方法返回结果 {}", response);
            logger.info("测试有参异步方法异常结果 {}", e);
            return response;
        }).handleAsync((response, e) -> {
            logger.info("测试有参异步方法返回结果 {}", response);
            logger.info("测试有参异步方法异常结果 {}", e);
            return response;
        });
        System.out.println(booleanCompletableFuture1.get());
        System.out.println("--------------");
        CompletableFuture<Boolean> booleanCompletableFuture2 = CompletableFuture.supplyAsync(() -> {
            logger.info("测试有参异步方法 {}", Thread.currentThread().getName());
            return true;
        }).handle((response, e) -> {
            logger.info("测试有参异步方法返回结果 {}", response);
            logger.info("测试有参异步方法异常结果 {}", e);
            return response;
        }).handleAsync((response, e) -> {
            logger.info("测试有参异步方法返回结果 {}", response);
            logger.info("测试有参异步方法异常结果 {}", e);
            return response;
        });
        System.out.println(booleanCompletableFuture2.get());
        logger.info("主线程结束执行任务 {}", Thread.currentThread().getName());
    }

    @Test
    public void testAsyncVoidThread() throws Exception{
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            logger.info("异步编程当前线程对象 {}", Thread.currentThread().getName());
            int i = 1 / 0;
        }).handle((response, e) -> {
            logger.info("异步编程响应结果 {}", response);
            logger.info("异步编程异常响应 {}", e.getMessage());
            return response;
        }).handleAsync((response, e) -> {
            logger.info("异步编程响应结果 {}", response);
            logger.info("异步编程异常响应 {}", e);
            return response;
        });
        System.out.println(voidCompletableFuture.get());
    }

    @Test
    public void testGetUserData() {
//        CompletableFuture.supplyAsync(() -> {
//            userMapper.insertUserBeanData(new UserBean(UUID.randomUUID().toString().replaceAll("-","")
//            ,"zhangsan"
//            ,"123456"
//            ,"976869901@qq.com"
//            ,"17879303721"
//            ,null));
//            return "";
//        });
//        CompletableFuture.supplyAsync(() -> {
//            List<UserBean> allUserBean = userMapper.findAllUserBean();
//            System.out.println(allUserBean);
//            return "";
//        });
        String name = "zhangsan";
        CompletableFuture.supplyAsync(() -> {
            logger.info("用户名称：{} ",name);
            return "";
        });
    }


    @Test
    public void testAsyncException() throws Exception{
        System.out.println(Thread.currentThread().getName() + ": " + System.currentTimeMillis() + "-------start");
        CompletableFuture<Object> handle = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "---------supplyAsync");
            int x = 1/0;
            return "2";
        }).handle((response, e) -> {
            if (e != null)
                logger.error(e.getMessage());
            if (response != null)
                logger.info(response.toString());
            System.out.println(Thread.currentThread().getName() + "---------handle");
            return response;
        });
        CompletableFuture<Object> handle1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "---------supplyAsync1");
            int x = 1/0;
            return "2";
        }).handle((response, e) -> {
            if (e != null)
                logger.error(e.getMessage());
            if (response != null)
                logger.info(response.toString());
            System.out.println(Thread.currentThread().getName() + "---------handle1");
            return response;
        });
        Object o = handle.get(3, TimeUnit.SECONDS);
        System.out.println(o);
        System.out.println(Thread.currentThread().getName() + ": " + System.currentTimeMillis() + "-------end");
    }


    @Test
    public void testAsyncMethod() throws Exception{

        CompletableFuture<String> day = CompletableFuture.supplyAsync(() -> {
            System.out.println("今天天气很好啊");
            return "今天天气很好啊";
        }).thenApplyAsync(result -> {
            System.out.println(result + "---");
            System.out.println(result + "!!!");
            return result + "!!!!";
        }, Executors.newFixedThreadPool(3));
        System.out.println(day.get(1, TimeUnit.SECONDS));
        // ---------------------
        CompletableFuture<Void> day1 = CompletableFuture.runAsync(() -> {
            System.out.println("今天天气很好啊1");
        });
        CompletableFuture.supplyAsync(() -> "测试有返回值的异步操作");
        try {
//            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("休眠异常");
        }
        System.out.println("今天练习一下异步编程，结合Java8实现案例。");
    }


    // 测试定长线程池的案例
    public static void main(String[] args) throws Exception{
        long currentTimeMillis = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(10000);
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            TestThreadDemo testThreadDemo = new TestThreadDemo(countDownLatch, i * 100, ((i + 1) * 100));
            executorService.submit(testThreadDemo);
        }
        countDownLatch.await();
        System.out.println(System.currentTimeMillis() - currentTimeMillis + "毫秒");
        executorService.shutdown();
    }

    public static class TestThreadDemo extends Thread {

        private CountDownLatch countDownLatch;
        private int start;
        private int end;

        public TestThreadDemo() {
        }

        public TestThreadDemo(CountDownLatch countDownLatch, int start, int end) {
            this.countDownLatch = countDownLatch;
            this.start = start;
            this.end = end;
        }

        public CountDownLatch getCountDownLatch() {
            return countDownLatch;
        }

        public void setCountDownLatch(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        public int getN() {
            return start;
        }

        public void setN(int n) {
            this.start = n;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                synchronized (this) {
                    countDownLatch.countDown();
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                }
            }
        }
    }

}
