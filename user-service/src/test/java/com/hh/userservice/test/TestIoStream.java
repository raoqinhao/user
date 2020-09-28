package com.hh.userservice.test;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.stream.Stream;

public class TestIoStream {



    @Test
    public void testGetExcelData() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\admin\\Desktop\\测试数据.xlsx"));
            bufferedReader.lines().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testIoStream() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\admin\\Desktop\\新建文本文档.txt"));
            Stream<String> lines = bufferedReader.lines();
            lines.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
