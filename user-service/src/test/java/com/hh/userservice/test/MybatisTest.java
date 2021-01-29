package com.hh.userservice.test;

import com.hh.userservice.mapper.UserMapper;
import com.hh.userservice.pojo.UserBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.Test;

import java.io.InputStream;
import java.util.UUID;

public class MybatisTest {

    @Test
    public void selectMybatisData() throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        Configuration configuration = sqlSessionFactory.getConfiguration();
        configuration.setCacheEnabled(false);
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.SIMPLE);
        UserBean selectOne = sqlSession.selectOne("com.hh.userservice.mapper.UserMapper.findUserBeanById", "a7fa3b5d5fae11eb830db42e99446dea");
        System.out.println(selectOne);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserBean userBean = mapper.findUserBeanById("a7fa3b5d5fae11eb830db42e99446dea");
        UserBean userBean1 = mapper.findUserBeanById("a7fa3b5d5fae11eb830db42e99446dea");
        System.out.println(userBean);
        System.out.println(userBean1);
    }


    @Test
    public void selectMybatisDataByUserName() throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.SIMPLE);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserBean userBean = mapper.findUserBeanByUserName("zhang");
        System.out.println(userBean);
    }


    @Test
    public void insertMybatisUserData() throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.SIMPLE,true);
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.SIMPLE);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserBean bean = new UserBean(UUID.randomUUID().toString().replaceAll("-","")
        ,"lisi","123456","994036938@qq.com","17806525487",null);
        mapper.insertUserBeanData(bean);
        sqlSession.commit();
    }

}
