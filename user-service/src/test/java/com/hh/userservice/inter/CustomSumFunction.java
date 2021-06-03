package com.hh.userservice.inter;

@FunctionalInterface
public interface CustomSumFunction<R,T> {

    R sum(T a, T b);

}
