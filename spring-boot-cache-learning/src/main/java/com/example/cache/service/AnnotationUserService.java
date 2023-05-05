package com.example.cache.service;

import com.example.cache.entity.User;
import com.example.cache.mapper.UserMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AnnotationUserService {

    @Resource
    private CacheManager cacheManager;
    @Resource
    private UserMapper userMapper;


    // key = "#root.caches[0]"
    // key = "#id"
    // condition = "#id % 2 == 1"
    // keyGenerator = "userKeyGenerator
    // unless = "#result.name.contains('张')"

    @Cacheable(value = {"user.get","user.find"},keyGenerator = "userKeyGenerator")
    public User get(String a,Double b) {

        System.out.println("执行了目标方法,没有从缓存中取出数据");
        return userMapper.get(1);
    }

    //unless = "#result.name.contains('张')"
    @Cacheable(value = {"user.get2"})
    public User get(Integer id) {
        return userMapper.get(id);
    }



    public User getUser(Integer id){
        User user = userMapper.get(id);
        User zs = User.builder().id(50).phone("123456").name("zs").build();
        return user;
    }

    @CachePut(value = "user.get2", key = "#user.id")
    public User update(User user) {
        userMapper.updateById(user);
        return user;
    }

    @CacheEvict(value = "user.get2", key = "#id",beforeInvocation = false)
    public void deleteById(Integer id) {
//        Cache cache = cacheManager.getCache("user.get2");
//        System.out.println(cache.get(id).get());
        // userMapper.deleteById(id);
        log.info("deleteById invoke ......");
    }

}
