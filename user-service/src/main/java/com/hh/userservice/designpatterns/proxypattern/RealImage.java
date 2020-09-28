package com.hh.userservice.designpatterns.proxypattern;

public class RealImage implements Image{

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("load " + fileName);
    }

    @Override
    public void display() {
        System.out.println("开始播放音乐：" + fileName);
    }

}
