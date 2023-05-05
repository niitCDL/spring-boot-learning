package com.example.cache.service;

import com.example.cache.entity.User;
import com.example.cache.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public User get(Integer id){
        return userMapper.get(id);
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public List<User> findAllByNameLike(String name){
        return userMapper.findAllByNameLike(name);
    }

}