package com.hh.userservice;

import com.hh.userservice.pojo.UserBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGetBeanByContext {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:user.xml");
        UserBean bean = applicationContext.getBean(UserBean.class);
        System.out.println(bean);
//        A bean = applicationContext.getBean(A.class);
//        System.out.println(bean);
    }
}
