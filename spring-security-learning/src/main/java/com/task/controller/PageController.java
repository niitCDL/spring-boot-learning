package com.task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/login")
    public String loginPage() {
        System.out.println("登录接口被访问到了");
        return "login";
    }

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }
}
