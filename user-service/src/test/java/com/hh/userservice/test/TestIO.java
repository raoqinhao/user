package com.hh.userservice.test;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.*;
import java.util.Objects;

public class TestIO {


    @Test
    public void stream1() throws Exception{
        InputStream fileInputStream = null;
        OutputStream fileOutputStream = null;
        try {
            String path = "E:\\image\\dog.jpg";
            fileInputStream = new FileInputStream(path);
            fileOutputStream = new FileOutputStream("E:\\image\\dog1.jpg");
            byte[] bytes = new byte[1024];
            while (fileInputStream.read(bytes) != -1) {
                for (int i = 0; i < bytes.length; i++) {
                    fileOutputStream.write(bytes[i]^2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!Objects.isNull(fileOutputStream))
                fileOutputStream.close();
            if (!Objects.isNull(fileInputStream))
                fileInputStream.close();
        }
    }

    @Test
    public void stream2() throws Exception{
        InputStream fileInputStream = null;
        OutputStream fileOutputStream = null;
        try {
            String path = "E:\\image\\dog1.jpg";
            fileInputStream = new FileInputStream(path);
            fileOutputStream = new FileOutputStream("E:\\image\\dog2.jpg");
            byte[] bytes = new byte[1024];
            while (fileInputStream.read(bytes) != -1) {
                for (int i = 0; i < bytes.length; i++) {
                    fileOutputStream.write(bytes[i]^2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!Objects.isNull(fileOutputStream))
                fileOutputStream.close();
            if (!Objects.isNull(fileInputStream))
                fileInputStream.close();
        }
    }


    @Test
    public void stream3() throws Exception{
        BufferedReader bufferedReader = null;
        try {
            String path = "E:\\image\\测试.txt";
            bufferedReader = new BufferedReader(new FileReader(path));
            char[] chars = new char[1024];
            while (bufferedReader.read(chars) != -1) {
                for (int i = 0; i < chars.length; i++) {
                    char aChar = chars[i];
                    System.out.println(aChar);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!Objects.isNull(bufferedReader))
                bufferedReader.close();
        }
    }

    @Test
    public void stream4() throws Exception{
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            long start = System.currentTimeMillis();
            bufferedInputStream = new BufferedInputStream(new FileInputStream("E:\\image\\测试.txt"));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("E:\\image\\测试1.txt"));
            byte[] bytes = new byte[1024];
            while (bufferedInputStream.read(bytes) != -1) {
                bufferedOutputStream.write(bytes);
            }
            long end = System.currentTimeMillis() - start;
            System.out.println(end);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!Objects.isNull(bufferedOutputStream))
                bufferedOutputStream.flush();
            if (!Objects.isNull(bufferedOutputStream))
                bufferedOutputStream.close();
            if (!Objects.isNull(bufferedInputStream))
                bufferedInputStream.close();
        }
    }
}
