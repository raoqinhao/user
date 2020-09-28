package com.hh.userservice.designpatterns.strategypattern;

public class StrategyContext implements Strategy{

    private Strategy strategy;

    public StrategyContext(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public int doOperation(int num1, int num2) {
        return strategy.doOperation(num1,num2);
    }
}
