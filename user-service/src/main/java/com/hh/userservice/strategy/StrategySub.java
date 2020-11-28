package com.hh.userservice.strategy;

import org.springframework.stereotype.Component;

@Component
public class StrategySub implements Strategy{

    @Override
    public int calculate(int a, int b) {
        return a - b;
    }
}
