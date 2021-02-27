package com.hh.userservice.test;

import java.util.concurrent.locks.LockSupport;

public class TestLockSupport {

    static Thread t1;
    static Thread t2;


    public static void main(String[] args) {
        int[] num = {1,2,3,4};
        String[] str = {"A","B","C","D"};
        t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < num.length; i++) {
                    System.out.println(num[i]);
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
        };
        t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < str.length; i++) {
                    LockSupport.park();
                    System.out.println(str[i]);
                    LockSupport.unpark(t1);
                }
            }
        };
        t1.start();
        t2.start();
    }

}
