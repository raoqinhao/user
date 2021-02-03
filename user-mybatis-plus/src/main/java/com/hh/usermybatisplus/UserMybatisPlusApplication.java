package com.hh.usermybatisplus;

        import org.mybatis.spring.annotation.MapperScan;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hh.usermybatisplus.mapper")
public class UserMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserMybatisPlusApplication.class, args);
    }

}
