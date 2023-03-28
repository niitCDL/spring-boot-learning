package top.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import top.example.web.event.MyEvent;
import top.example.web.listener.MyListener1;

@SpringBootApplication
//@ServletComponentScan
public class MyApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MyApplication.class, args);
        context.addApplicationListener(new MyListener1());
        context.publishEvent(new MyEvent("测试事件"));
    }
}