package com.hh.userservice.strategy;

import org.springframework.stereotype.Component;

@Component
public class StrategyMul implements Strategy{
    @Override
    public int calculate(int a, int b) {
        return a * b;
    }
}
