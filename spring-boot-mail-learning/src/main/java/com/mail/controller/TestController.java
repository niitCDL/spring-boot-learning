package com.mail.controller;

import com.mail.entity.Article;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TestController {

    @GetMapping("/get")
    public Article getArticle(){
        return new Article(1,"Spring",new Date());
    }

}
