package com.hh.userservice.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestLimit {

    @Test
    public void testLambdaStream() {

        List arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(4);

        List sortList = (List) arrayList.stream().sorted().skip(2).limit(2).collect(Collectors.toList());
        sortList.forEach(System.out::println);

    }

}
