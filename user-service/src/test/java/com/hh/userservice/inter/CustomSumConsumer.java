package com.hh.userservice.inter;

/**
 * @ClassName CustomSumConsumer
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/5/24 13:56
 * @Version 1.0
 **/
@FunctionalInterface
public interface CustomSumConsumer<T> {

    void consumerData(T t1, T t2);

}
