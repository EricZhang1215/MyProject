package com.zqs.demo1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot启动类.
 */
@SpringBootApplication
//@ComponentScan(value = "com.zqs.demo1.*")
@MapperScan("com.zqs.*") //扫描：该包下相应的class,主要是MyBatis的持久化类. 目录要为上级
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
