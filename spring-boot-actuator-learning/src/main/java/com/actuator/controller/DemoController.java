package com.actuator.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Resource
    private MeterRegistry meterRegistry;


    private Counter counter;

    @PostConstruct
    public void init(){
        counter = meterRegistry.counter("demo.request");
    }

    @GetMapping("/demo")
    public String demo(){
        counter.increment();
        return "demo";
    }

}
