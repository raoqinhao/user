package com.hh.userservice.test;

import com.hh.userservice.Clothes;
import com.hh.userservice.Person;
import com.hh.userservice.User;

import java.util.ArrayList;
import java.util.List;

public class TestGenericClass {

    public static void main(String[] args) {

        List<? extends User> genericExtends = new ArrayList<>();
        genericExtends.add(null);
//        genericExtends.add(new User());   //使用泛型上界的时候，集合中并不能存放父级和子级对象
//        genericExtends.add(new Person());   //使用泛型上界的时候，集合中并不能存放父级和子级对象
        List<? super Person> genericSuper = new ArrayList<>();
        genericSuper.add(new Person("亚洲","黑色"));  //使用泛型下界的时候，集合中可以用来存放下界的对象及子类对象
        genericSuper.add(new Clothes("100元","白色")); //使用泛型下界的时候，集合中可以用来存放下界的对象及子类对象
        System.out.println(genericSuper.get(0));
        System.out.println(genericSuper.get(1));

    }

}
