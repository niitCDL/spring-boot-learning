package com.task.config;

import com.task.service.MyService;
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
