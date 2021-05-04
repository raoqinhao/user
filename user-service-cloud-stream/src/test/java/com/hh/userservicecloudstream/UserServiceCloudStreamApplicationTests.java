package com.hh.userservicecloudstream;

import com.hh.userservicecloudstream.consume.MsgReceive;
import com.hh.userservicecloudstream.provide.MsgSend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = UserServiceCloudStreamApplication.class)
@RunWith(SpringRunner.class)
public class UserServiceCloudStreamApplicationTests {

    @Autowired
    private MsgSend msgSend;

    @Autowired
    private MsgReceive msgReceive;

    @Test
    public void sendMsg() {
        msgSend.sendMsg("{'username':'zhangsan','age':'18'}");
    }

}
