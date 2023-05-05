package com.actuator.config;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ApplicationInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("appName","spring-boot-actuator");
        Map<String,Object> data = new HashMap<>();
        data.put("version","1.0.0");
        builder.withDetails(data);
    }
}
