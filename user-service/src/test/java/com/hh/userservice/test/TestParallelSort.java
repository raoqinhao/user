package com.hh.userservice.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * @ClassName TestParallelSort
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/4/21 9:43
 * @Version 1.0
 **/
public class TestParallelSort {

    /***
    * 功能描述:<br>
    * @参数
    * @描述: java8中的并行排序
    * @创建人: 饶钦浩
    * @时间: ${DATE} ${TIME}
    * @return
    * @throws
    */
    @Test
    public void testParallelSortJava8() {
        int[] ints = {1, 3, 4, 5, 2, 6, 9, 7};
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
        System.out.println("----------");
        Arrays.parallelSort(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    @Test
    public void testStampedLockJava8() throws Exception{
        StampedLock stampedLock = new StampedLock();
        try {
            long l = stampedLock.readLock();
            int a = 9;
            int b = 10;
            System.out.println(a + b);
            System.out.println(l);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stampedLock.tryUnlockRead();
        }

    }

}
