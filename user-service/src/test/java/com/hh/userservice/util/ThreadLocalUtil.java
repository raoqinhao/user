package com.hh.userservice.util;

import com.hh.userservice.inter.Person;
import org.springframework.stereotype.Component;

@Component
public class ThreadLocalUtil {

    private static ThreadLocal threadLocal = new ThreadLocal();

    public static void set(String value) {
        threadLocal.set(value);
    }

    public static String get() {
        return (String) threadLocal.get();
    }

    public static void main(String[] args) {
        Thread.yield();
        Runnable person1 = () -> {
            ThreadLocalUtil.set("222");
            System.out.println(ThreadLocalUtil.get());
        };
        Thread thread1 = new Thread(person1);
        thread1.start();
        System.out.println(ThreadLocalUtil.get());

        System.out.println("----");
        String a = "123";
        Person person = () -> ThreadLocalUtil.set(a);
        System.out.println(ThreadLocalUtil.get());
        System.out.println(String.format("分割 %s","----"));
        ThreadLocalUtil.set("测试");
        System.out.println(ThreadLocalUtil.get());
        Runnable runnable = () -> System.out.println(ThreadLocalUtil.get());
        Thread thread = new Thread(runnable);
        thread.setName("A");
        thread.start();
        System.out.println("---------------");
        String aStr = "123456";
        int length = aStr.substring(0, aStr.length() - 1).length();
        System.out.println(length);
        System.out.println(aStr.substring(0, aStr.length() - 1));
    }

}
