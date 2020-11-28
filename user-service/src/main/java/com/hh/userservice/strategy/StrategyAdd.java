package com.hh.userservice.strategy;

import org.springframework.stereotype.Component;

@Component
public class StrategyAdd implements Strategy{

    @Override
    public int calculate(int a, int b) {
        return a + b;
    }

}
