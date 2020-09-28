package com.hh.userservice.designpatterns.proxypattern;

public class ProxyPatternDemo {

    public static void main(String[] args) {
        String fileName = "战争世界.mp3";
        ProxyImage proxyImage = new ProxyImage(fileName);
        proxyImage.display();
    }

}
