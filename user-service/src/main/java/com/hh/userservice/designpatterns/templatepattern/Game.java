package com.hh.userservice.designpatterns.templatepattern;

public abstract class Game {

    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    public final void display() {
        initialize();
        startPlay();
        endPlay();
    }
}
