package com.hh.userservice.test;

import com.hh.userservice.pojo.UserBean;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.UUID;

public class TestReflection {


    @Test
    public void getUserBeanDataByReflection() throws Exception{
        UserBean userBean = new UserBean(UUID.randomUUID().toString().replaceAll("-","")
                ,"lisi","123456","994036938@qq.com","17806525487",null);
        Class<? extends UserBean> userBeanClass = userBean.getClass();
        Field usernameField = userBeanClass.getDeclaredField("username");
        String name = usernameField.getName();
        Class<?> type = usernameField.getType();
        System.out.println(name + "---" + type);
        usernameField.setAccessible(true);
        Object o = usernameField.get(userBean);
        System.out.println(o);
    }



    @Test
    public void getUserBeanDataByConstructor() throws Exception{
        Class<? extends UserBean> userBeanClass = UserBean.class;
        Constructor<? extends UserBean> declaredConstructor = userBeanClass.getDeclaredConstructor();
        UserBean userBean = declaredConstructor.newInstance();
        System.out.println(userBean);
    }


    @Test
    public void getUserBeanDataByMethod() throws Exception{
        UserBean userBean = new UserBean(UUID.randomUUID().toString().replaceAll("-","")
                ,"lisi","123456","994036938@qq.com","17806525487",null);
        Class<? extends UserBean> userBeanClass = userBean.getClass();
        Method setUsername = userBeanClass.getMethod("setUsername", String.class);
        setUsername.invoke(userBean,"张桑");
        System.out.println(userBean);
    }

    @Test
    public void getUserBeanDataByAnno() throws Exception{
        UserBean userBean = new UserBean(UUID.randomUUID().toString().replaceAll("-","")
                ,"lisi","123456","994036938@qq.com","17806525487",null);
        Class<? extends UserBean> userBeanClass = userBean.getClass();
        Annotation[] annotations = userBeanClass.getDeclaredAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            String name = annotations[i].getClass().getName();
            String typeName = annotations[i].getClass().getTypeName();
            System.out.println(name);
            System.out.println(typeName);
        }
    }


    @Test
    public void getUserBeanDataModifiers() throws Exception{
        UserBean userBean = new UserBean(UUID.randomUUID().toString().replaceAll("-","")
                ,"lisi","123456","994036938@qq.com","17806525487",null);
        Class<? extends UserBean> userBeanClass = userBean.getClass();
        int modifiers = userBeanClass.getModifiers();
        System.out.println(modifiers);
    }
}
