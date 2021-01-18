package com.hh.userservice.thread;

import com.hh.userservice.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.java2d.SurfaceDataProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class TestFixedThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = null;
        try {
            executorService = Executors.newFixedThreadPool(10);
            List<User> userList = getUserList();
            int pageNum = userList.size() % 10 == 0 ? (userList.size() / 10) : (userList.size() / 10) + 1;
            CountDownLatch countDownLatch = new CountDownLatch(userList.size());
            for (int i = 0; i < pageNum; i++) {
                List<User> userData = userList.parallelStream().skip(i * 10).limit(10).collect(Collectors.toCollection(ArrayList::new));
                MultiPartThread multiPartThread = new MultiPartThread(countDownLatch,userData);
                executorService.execute(multiPartThread);
            }
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (executorService != null)
                executorService.shutdown();
        }

    }

    public static List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 777; i++) {
            userList.add(new User("R" + i, i));
        }
        return userList;
    }

}
class MultiPartThread implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(MultiPartThread.class);

    private CountDownLatch countDownLatch;

    private List<User> userData;

    public MultiPartThread(CountDownLatch countDownLatch, List<User> userData) {
        this.countDownLatch = countDownLatch;
        this.userData = userData;
    }

    @Override
    public void run() {
        for (int i = 0; i < userData.size(); i++) {
            synchronized (this) {
                try {
                    countDownLatch.countDown();
                    logger.info("用户名称： {} ,计数器： {}" , userData.get(i).getUserName(), countDownLatch.getCount());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}