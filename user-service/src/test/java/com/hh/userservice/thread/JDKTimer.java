package com.hh.userservice.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName JDKTimer
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/7/23 9:56
 * @Version 1.0
 **/
public class JDKTimer {
    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.scheduleAtFixedRate(new TimerSchedule(), 1, 2, TimeUnit.SECONDS);

    }
}
class TimerSchedule implements Runnable {

    @Override
    public void run() {
//        try {
//            int count = 0;
//            while (count <= 10) {
//                Thread.sleep(1000);
//                if (count == 10) {
//                    int i = count / 0;
//                }
//                count++;
//                System.out.println(count);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        System.out.println("开始执行代码");
        int count = 0;
        int i = count / 0;
        System.out.println("异常后，任务进行执行成功！");
    }

}