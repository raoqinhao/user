package com.hh.userservice.designpatterns.templatepattern;

public class Football extends Game{

    @Override
    void initialize() {
        System.out.println("初始化游戏");
    }

    @Override
    void startPlay() {
        System.out.println("开始游戏");
    }

    @Override
    void endPlay() {
        System.out.println("游戏结束");
    }
}
