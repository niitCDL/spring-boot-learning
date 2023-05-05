package com.example.cache.service;

import com.example.cache.entity.User;
import com.example.cache.mapper.UserMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RedisCacheService {

    @Resource
    private UserMapper userMapper;


    @Cacheable(value = "getName")
    public String getName(Integer i) {
        log.info("getName invoke ......");
        return "name" + i;
    }
    //value = "getUser"
    // cacheManager = "userCacheManager"
    @Cacheable(value = "getUser",cacheManager = "userCacheManager")
    public User getUser(Integer id) {
        return userMapper.get(id);
    }
}