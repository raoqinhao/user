package com.hh.userservice.util;

import com.hh.userservice.inter.CustomSumFunction;

/**
 * @ClassName ConsumerUtil
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/6/18 13:59
 * @Version 1.0
 **/
public class ConsumerUtil {

    public static int sum(int a, int b, CustomSumFunction<Integer,Integer> customSumFunction) {
        System.out.println(a + " ---- " + b);
        return customSumFunction.sum(a,b);
    }

}
