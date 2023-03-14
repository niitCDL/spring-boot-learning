package com.example.config;

import com.example.service.MyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Configuration
@Component
public class MyConfig {

//    @Bean
//    @Scope("prototype")
    public MyService myService(){
        return new MyService();
    }

}
