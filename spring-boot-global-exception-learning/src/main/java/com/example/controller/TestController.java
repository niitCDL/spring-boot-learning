package com.example.controller;

import com.example.auth.CheckAuth;
import com.example.domain.Article;
import com.example.service.ExceptionService;
import com.example.util.AjaxResponse;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api")
public class TestController {

    @Resource
    private ExceptionService exceptionService;

    @GetMapping("/articles/{id}")
    @CheckAuth(value = "admin")
    public AjaxResponse getArticle(@PathVariable("id")int id){
        if (id > 3){
            exceptionService.systemBizError();
        } else if (id <= 0) {
            exceptionService.userBizError(id);
        }
        return AjaxResponse.success(findArticleById(id));
    }

    @PostMapping("/saveArticle")

    public AjaxResponse saveArticle(@Valid @RequestBody Article article){
        return AjaxResponse.success(article);
    }

    private Article findArticleById(int id){
        List<Article> articles = List.of(new Article(1, "Spring 从入门到精通", "大佬","spring@qq.com", LocalDateTime.of(2023,3,20,12,0,0)),
                new Article(2, "Spring Boot 从入门到精通", "大牛","springboot@qq.com", LocalDateTime.of(2023,3,20,12,0,0)),
                new Article(3, "Spring Cloud 从入门到精通", "大神","springcloud@qq.com", LocalDateTime.of(2023,3,20,12,0,0)));
        return articles.stream().filter(article -> article.getId() == id).toList().get(0);
    }
}
