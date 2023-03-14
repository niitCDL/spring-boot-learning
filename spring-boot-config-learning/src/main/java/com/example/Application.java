package com.example;

import com.example.config.DBConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class Application {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//        ConfigurableApplicationContext  run =
//                SpringApplication.run(Application.class, args);
//        Person bean = run.getBean(Person.class);
//        Student student = run.getBean(Student.class);
//        MyProperties bean1 = run.getBean(MyProperties.class);
//        System.out.println(bean);
//        System.out.println(student);
//        System.out.println(bean1);

        SpringApplication.run(Application.class, args);
    }
}