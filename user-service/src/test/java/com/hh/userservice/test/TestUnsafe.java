package com.hh.userservice.test;

import com.hh.userservice.User;
import org.junit.Test;
import sun.misc.Unsafe;

/**
 * @ClassName TestUnsafe
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/4/15 10:23
 * @Version 1.0
 **/
public class TestUnsafe {

    @Test
    public void testUnsafeAllocateMethod() throws Exception{
        Unsafe unsafe = Unsafe.getUnsafe();
        User userOrdinary = User.class.newInstance();
        userOrdinary.setUserAge(20);
        userOrdinary.setUserName("李四");
        User userUnsafe = (User) unsafe.allocateInstance(User.class);
        userUnsafe.setUserAge(10);
        userUnsafe.setUserName("张三");
        System.out.println(userOrdinary);
        System.out.println(userUnsafe);
    }

}
