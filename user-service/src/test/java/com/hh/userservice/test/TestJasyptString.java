package com.hh.userservice.test;

import com.hh.userservice.UserServiceApplication;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName TestJasyptString
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/8/11 9:09
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserServiceApplication.class)
public class TestJasyptString {

    @Autowired
    private StringEncryptor stringEncryptor;

    @Test
    public void testEncryptor() {
        try {
            System.out.println(stringEncryptor.decrypt("PNQNN+w8P1uPyU5N7mtlzw=="));
            System.out.println(stringEncryptor.decrypt("DsGfUK5vTf2MK3JFiKs7iQ=="));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(stringEncryptor.encrypt("sjcx"));
            System.out.println(stringEncryptor.decrypt("9k6p/agd1LVUe8v6WL/dNA=="));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
