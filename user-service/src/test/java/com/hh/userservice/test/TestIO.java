package com.hh.userservice.test;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class TestIO {


    @Test
    public void stream1() throws Exception{
        String path = "E:\\image\\dog.jpg";
        InputStream inputStream = new FileInputStream(path);
        OutputStream fileOutputStream = new FileOutputStream("E:\\image\\dog1.jpg");
        byte[] bytes = new byte[1024];
        while (inputStream.read(bytes) != -1) {
            for (int i = 0; i < bytes.length; i++) {
                fileOutputStream.write(bytes[i]^2);
            }
        }
    }

    @Test
    public void stream2() throws Exception{
        String path = "E:\\image\\dog1.jpg";
        InputStream inputStream = new FileInputStream(path);
        OutputStream fileOutputStream = new FileOutputStream("E:\\image\\dog2.jpg");
        byte[] bytes = new byte[1024];
        while (inputStream.read(bytes) != -1) {
            for (int i = 0; i < bytes.length; i++) {
                fileOutputStream.write(bytes[i]^2);
            }
        }
    }

}
