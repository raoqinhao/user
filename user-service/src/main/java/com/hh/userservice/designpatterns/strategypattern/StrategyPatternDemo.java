package com.hh.userservice.designpatterns.strategypattern;

public class StrategyPatternDemo {

    public static void main(String[] args) {
        Strategy strategy = new PlusStrategy();
        StrategyContext strategyContext = new StrategyContext(strategy);
        int i = strategyContext.doOperation(1, 2);
        System.out.println(i);
    }

}
