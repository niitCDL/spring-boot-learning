package com.example.cache.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.time.Duration;


@Configuration(proxyBeanMethods = false)
public class RedisConfiguration {


    /*
        必须像流式编程一样,流水线的样式,分开写配置是不生效的
        分开写的例子: config = RedisCacheConfiguration.defaultCacheConfig()
                    config.prefixCacheNameWith("myRedis_")
                    这种写法是会失效的
        正确的例子 config = RedisCacheConfiguration.defaultCacheConfig().prefixCacheNameWith("myRedis_")

        当在配置类中配置了RedisCacheConfiguration类,则会覆盖application.yml文件中全局配置的redis设置
     */
    @Bean
    public RedisCacheConfiguration redisCacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(
                RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json()))
                .prefixCacheNameWith("myRedis_")
                .entryTtl(Duration.ofSeconds(90));
    }

    @Bean
    public RedisCacheManager userCacheManager(RedisConnectionFactory connectionFactory,
                                              RedisCacheConfiguration redisCacheConfiguration) {
        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(redisCacheConfiguration.entryTtl(Duration.ofSeconds(60))).build();
    }
}
