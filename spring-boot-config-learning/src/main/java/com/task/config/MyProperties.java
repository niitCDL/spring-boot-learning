package com.task.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@PropertySource("classpath:my.properties")
@ConfigurationProperties(prefix = "my")
public class MyProperties {
    private String url;
    private String username;
    private String password;
}
