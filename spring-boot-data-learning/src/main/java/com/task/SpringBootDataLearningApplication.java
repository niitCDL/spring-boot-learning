package com.task;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mapper")
public class SpringBootDataLearningApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataLearningApplication.class,args);
    }
}