package com.task.controller;


import com.task.domain.Article;
import com.task.repository.ArticleRepository;
import com.task.repository.DiscussRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private DiscussRepository discussRepository;

    @GetMapping("/")
    public String getAllArticle(ModelMap map){
        List<Article> articleList = articleRepository.findAll();
        map.put("articleList",articleList);
        return "index.html";
    }

    @GetMapping("/book/detail/{id}")
    public String getBookDetail(@PathVariable("id") Integer id, ModelMap map){
        Article article = articleRepository.getArticleById(id);
        map.put("article",article);
        return "detail.html";
    }

}
