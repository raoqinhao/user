package com.hh.userservicemongodb;

import com.hh.userservicemongodb.mapper.UserMapper;
import com.hh.userservicemongodb.pojo.AgeSum;
import com.hh.userservicemongodb.pojo.User;
import com.mongodb.QueryBuilder;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TestMongoDB
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/6/18 14:44
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserServiceMongodbApplication.class)
public class TestMongoDB {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void findAllUser() {
        List<User> userList = userMapper.findAll();
        userList.forEach(System.out::println);
    }

    @Test
    public void findUserByCondition() {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("age", ExampleMatcher.GenericPropertyMatchers.contains())
                .withIgnorePaths("id","_class");
        Example example = Example.of(new User(null,"lisi",null), exampleMatcher);
        List<User> userList = userMapper.findAll(example);
        userList.forEach(System.out::println);
    }

    @Test
    public void findUserByOrder() {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("age", ExampleMatcher.GenericPropertyMatchers.contains())
                .withIgnorePaths("id","_class");
        List<User> userList = userMapper.findAll(Sort.by("age").descending());
        userList.forEach(System.out::println);
        System.out.println("-------------");
        List<User> userList1 = userMapper.findAll(Sort.by("age").ascending());
        userList1.forEach(System.out::println);
    }

    @Test
    public void findUserByLimit() {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("age", ExampleMatcher.GenericPropertyMatchers.contains())
                .withIgnorePaths("id","_class");
        Example example = Example.of(new User(null,null,null), exampleMatcher);
        List<User> userList1 = userMapper.findAll(example);
        userList1.forEach(System.out::println);
        System.out.println("------------");
        Page<User> userPage = userMapper.findAll(example, new PageRequest(0, 2));
        userPage.get().forEach(System.out::println);
    }

    @Test
    public void findUserByTemplate() {
        Criteria criteria = Criteria.where("name").is("zhaoqi").where("age").is(22.0);
        Query query = new Query(criteria);
        List<User> users = mongoTemplate.find(query, User.class);
        users.forEach(System.out::println);
    }

    @Test
    public void findUserByTemplateLimit() {
        Query query = new Query();
        List<User> users = mongoTemplate.find(query.skip(2).limit(2), User.class);
        users.forEach(System.out::println);
    }

    @Test
    public void insertUser() {
        User insert = mongoTemplate.insert(new User(null, "zhangsan", "15"));
        System.out.println(insert);
    }

    @Test
    public void aggSum() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("_id").sum("age").as("total")
        );
        AggregationResults<ResultSumData> user = mongoTemplate.aggregate(aggregation, "user", ResultSumData.class);
        List<ResultSumData> mappedResults = user.getMappedResults();
        for (int i = 0; i < mappedResults.size(); i++) {
            ResultSumData resultData = mappedResults.get(i);
            System.out.println(resultData);
        }
    }

    @Test
    public void aggCount() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("_id").count().as("count")
        );
        AggregationResults<ResultCountData> user = mongoTemplate.aggregate(aggregation, "user", ResultCountData.class);
        List<ResultCountData> mappedResults = user.getMappedResults();
        for (int i = 0; i < mappedResults.size(); i++) {
            ResultCountData resultData = mappedResults.get(i);
            System.out.println(resultData);
        }
    }

    @Test
    public void agg() {
        Criteria criteria = Criteria.where("name").is("zhaoqi").where("age").is(22.0);
        Query query = new Query(criteria);
        long count = mongoTemplate.count(query, User.class); // 统计数据量，通过添加筛选条件
        System.out.println(count);
        long count1 = mongoTemplate.count(new Query(), User.class); // 统计所有数据量
        System.out.println(count1);
    }

}
@Data
class ResultSumData {
    private String _id;
    private String total;
}
@Data
class ResultCountData {
    private String _id;
    private String count;
}