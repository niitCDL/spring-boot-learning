package com.task;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication
@MapperScan("com.example.auth.mapper")
public class HelloSecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloSecurityApplication.class, args);
    }
}
