package com.hh.userservice.test;

import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {

    @Test
    public void testTimerSchedule() {
        for (int i = 0; i < 10; i++) {
            Timer timer = new Timer();
            TimerTask timerTask = new TimerTask(){
                @Override
                public void run() {
                    System.out.println("开启定时线程任务：" + System.currentTimeMillis() + ", 当前线程名称：" + Thread.currentThread().getName());
                }
            };
            timer.schedule(timerTask, 1000);
        }
    }


    @Test
    public void testTimer_1() {
        for (int i = 0; i < 10; ++i) {
            new Timer("timer - " + i).schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " run ");
                }
            }, 1000);
        }
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask(){
            @Override
            public void run() {
                System.out.println("开启定时线程任务：" + System.currentTimeMillis() + ", 当前线程名称：" + Thread.currentThread().getName());
            }
        };
        timer.schedule(timerTask, 1000);
    }
}
