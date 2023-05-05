package com.docs.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "HelloController",description = "测试接口")
public class HelloController {

    @GetMapping("/hello")
    @Operation(summary = "hello",description = "测试接口的 test 方法")
    public String test(){
        return "hello springdocs";
    }

    @GetMapping("/hello1")
    @Operation(summary = "hello",description = "测试接口的 test1 方法")
    public String test1(){
        return "hello springdocs";
    }
}
