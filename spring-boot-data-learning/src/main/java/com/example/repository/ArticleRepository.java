package com.example.repository;

import com.example.domain.Article;
import com.example.domain.Discuss;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * JpaRepository<处理的映射对象,对象主键的ID类型>
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer> {

    List<Article> findAll();

    Article getArticleById(Integer id);
}
