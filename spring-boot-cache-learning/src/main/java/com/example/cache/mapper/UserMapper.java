package com.example.cache.mapper;

import com.example.cache.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select * from tb_user where id = #{value}")
    User get(Integer id);

    @Select("select * FROM tb_user ")
    List<User> findAll();

    @Select("SELECT * FROM tb_user WHERE name LIKE concat('%', #{name}, '%')")
    List<User> findAllByNameLike(@Param("name") String name);

    @Update("UPDATE tb_user SET name = #{name} WHERE id = #{id}")
    void updateById(User user);

}