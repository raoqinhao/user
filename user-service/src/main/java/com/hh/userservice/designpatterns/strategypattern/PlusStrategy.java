package com.hh.userservice.designpatterns.strategypattern;

public class PlusStrategy implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
