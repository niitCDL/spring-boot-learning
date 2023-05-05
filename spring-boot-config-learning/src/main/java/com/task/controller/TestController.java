package com.task.controller;

import com.task.config.DBConfig;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TestController {
    private final DBConfig dbConfig;

    @GetMapping("/show")
    public String show(){
        return dbConfig.configure();
    }


    @GetMapping("/login2")
    public void login2(){
        System.out.println("login2");
    }
}
