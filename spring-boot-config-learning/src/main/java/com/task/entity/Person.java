package com.task.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "person")
@Data
public class Person {
    private Integer id;
    private String name;
    private List<String> hobby;
    private String[] family;
    private Map<String,Object> map;
    private Pet pet;
}
