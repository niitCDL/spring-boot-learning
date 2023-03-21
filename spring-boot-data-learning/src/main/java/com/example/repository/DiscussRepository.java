package com.example.repository;

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
public interface DiscussRepository extends JpaRepository<Discuss,Integer> {

    List<Discuss> findByAuthorNotNull();

    Discuss findByAuthorEquals(String author);

    Discuss findByAuthor(String author);

    List<Discuss> findByAuthorLike(String condition);


    List<Discuss> findByAId(Integer aid);

    @Query("SELECT c FROM t_comment c where c.AId = ?1")
    List<Discuss> getDiscussesByPage(Integer aId,Pageable pageable);

}
