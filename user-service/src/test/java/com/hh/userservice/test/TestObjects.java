package com.hh.userservice.test;

import com.hh.userservice.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class TestObjects {



    @Test
    public void testObjects() {
        List<User> userList = new ArrayList<>();
        List<User> list = new ArrayList<>();
        list.add(new User("zhangsan",12));
        list.add(new User("zhangsan",18));

        if (!Objects.isNull(userList)) {
            User user = list.get(0);
            System.out.println(user);
        }
    }

}
