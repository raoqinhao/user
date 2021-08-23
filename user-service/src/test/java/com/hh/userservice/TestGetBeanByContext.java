package com.hh.userservice;

import com.hh.userservice.pojo.UserBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGetBeanByContext {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:user.xml");
        UserBean bean = applicationContext.getBean(UserBean.class);
        System.out.println(bean);
//        A bean = applicationContext.getBean(A.class);
//        System.out.println(bean);
//        ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(UserConfig.class);
//        User bean = annotationConfigApplicationContext.getBean(User.class);
//        System.out.println(bean);
//        System.out.println("----");
//        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
//        for (int i = 0; i < beanDefinitionNames.length; i++) {
//            String beanDefinitionName = beanDefinitionNames[i];
//            System.out.println(beanDefinitionName);
//        }

    }
}
