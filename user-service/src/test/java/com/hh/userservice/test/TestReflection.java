//package com.hh.userservice.test;
//
//import com.hh.userservice.User;
//import com.hh.userservice.annotation.VerifyFieldStatus;
//import com.hh.userservice.pojo.UserBean;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.junit.Test;
//import org.springframework.stereotype.Component;
//
//import java.lang.annotation.Annotation;
//import java.lang.reflect.Constructor;
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//import java.util.Set;
//import java.util.UUID;
//
//public class TestReflection {
//
//    @Test
//    public void getUserByAnnotation() throws Exception {
//        Class<User> userClass = User.class;
//        Field userNameField = userClass.getDeclaredField("userName");
//        Field userAgeField = userClass.getDeclaredField("userAge");
//        VerifyFieldStatus userNameAnnotation = userNameField.getAnnotation(VerifyFieldStatus.class);
//        System.out.println(userNameAnnotation.value());
//        VerifyFieldStatus userAgeAnnotation = userAgeField.getAnnotation(VerifyFieldStatus.class);
//        System.out.println(userAgeAnnotation.value());
//    }
//
//    @Test
//    public void getUserDataByReflection() throws Exception {
//        Class<UserBean> userBeanClass = UserBean.class;
//        Constructor<UserBean> declaredConstructor = userBeanClass.getDeclaredConstructor(String.class, String.class, String.class, String.class, String.class, Set.class);
//        UserBean userBean = declaredConstructor.newInstance("123", "zhangsan", "123456", "976869901@qq.com", "17879303721",null);
//        System.out.println(userBean);
//        System.out.println("------------");
//        Class<? extends UserBean> aClass = userBean.getClass();
//        Field userNameField = aClass.getDeclaredField("username");
//        userNameField.setAccessible(true);
//        userNameField.set(userBean,"lisi");
//        System.out.println(userBean);
//        System.out.println("----------");
//        Class<? extends UserBean> aClass1 = userBean.getClass();
//        Method method = aClass1.getDeclaredMethod("setId", String.class);
//        method.invoke(userBean, "123456789");
//        System.out.println(userBean);
//        System.out.println("------------");
//        Class<? extends UserBean> aClass2 = userBean.getClass();
//        Data declaredAnnotation = aClass2.getDeclaredAnnotation(Data.class);
//        Component declaredAnnotation1 = aClass2.getDeclaredAnnotation(Component.class);
//        NoArgsConstructor declaredAnnotation2 = aClass2.getDeclaredAnnotation(NoArgsConstructor.class);
//        AllArgsConstructor declaredAnnotation3 = aClass2.getDeclaredAnnotation(AllArgsConstructor.class);
//        System.out.println(declaredAnnotation);
//        System.out.println(declaredAnnotation1);
//        System.out.println(declaredAnnotation2);
//        System.out.println(declaredAnnotation3);
//
//
//    }
//
//    @Test
//    public void getUserBeanDataByReflection() throws Exception{
//        UserBean userBean = new UserBean(UUID.randomUUID().toString().replaceAll("-","")
//                ,"lisi","123456","994036938@qq.com","17806525487",null);
//        Class<? extends UserBean> userBeanClass = userBean.getClass();
//        Field usernameField = userBeanClass.getDeclaredField("username");
//        String name = usernameField.getName();
//        Class<?> type = usernameField.getType();
//        System.out.println(name + "---" + type);
//        usernameField.setAccessible(true);
//        Object o = usernameField.get(userBean);
//        System.out.println(o);
//    }
//
//
//
//    @Test
//    public void getUserBeanDataByConstructor() throws Exception{
//        Class<? extends UserBean> userBeanClass = UserBean.class;
//        Constructor<? extends UserBean> declaredConstructor = userBeanClass.getDeclaredConstructor();
//        UserBean userBean = declaredConstructor.newInstance();
//        System.out.println(userBean);
//    }
//
//
//    @Test
//    public void getUserBeanDataByMethod() throws Exception{
//        UserBean userBean = new UserBean(UUID.randomUUID().toString().replaceAll("-","")
//                ,"lisi","123456","994036938@qq.com","17806525487",null);
//        Class<? extends UserBean> userBeanClass = userBean.getClass();
//        Method setUsername = userBeanClass.getMethod("setUsername", String.class);
//        setUsername.invoke(userBean,"张桑");
//        System.out.println(userBean);
//    }
//
//    @Test
//    public void getUserBeanDataByAnno() throws Exception{
//        UserBean userBean = new UserBean(UUID.randomUUID().toString().replaceAll("-","")
//                ,"lisi","123456","994036938@qq.com","17806525487",null);
//        Class<? extends UserBean> userBeanClass = userBean.getClass();
//        Annotation[] annotations = userBeanClass.getDeclaredAnnotations();
//        for (int i = 0; i < annotations.length; i++) {
//            String name = annotations[i].getClass().getName();
//            String typeName = annotations[i].getClass().getTypeName();
//            System.out.println(name);
//            System.out.println(typeName);
//        }
//    }
//
//
//    @Test
//    public void getUserBeanDataModifiers() throws Exception{
//        UserBean userBean = new UserBean(UUID.randomUUID().toString().replaceAll("-","")
//                ,"lisi","123456","994036938@qq.com","17806525487",null);
//        Class<? extends UserBean> userBeanClass = userBean.getClass();
//        int modifiers = userBeanClass.getModifiers();
//        System.out.println(modifiers);
//    }
//}
