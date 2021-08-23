package com.hh.userservicemongodb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * @ClassName User
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/6/18 14:47
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;
    private String name;
    private String age;

}
