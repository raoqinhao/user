package com.hh.userservicedynamicdatasource;

import com.hh.userservicedynamicdatasource.mapper.UserMapper;
import com.hh.userservicedynamicdatasource.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserServiceDynamicDatasourceApplication.class)
public class UserServiceDynamicDatasourceApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testC() {
        List<User> userList = userMapper.getUserList();
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).toString());
        }
    }

}
