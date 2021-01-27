package com.hh.userservice.test;

import com.hh.userservice.mapper.UserMapper;
import com.hh.userservice.pojo.UserBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class MybatisTest {

    @Test
    public void testMybatis() throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserBean userBean = mapper.findUserBeanById("a7fa3b5d5fae11eb830db42e99446dea");
        System.out.println(userBean);

    }


}
