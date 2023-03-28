package top.example.web.config;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.example.web.interceptor.AuthInterceptor;
import top.example.web.interceptor.CustomInterceptor;

@Configuration
@Slf4j
public class MvcConfig implements WebMvcConfigurer {

    private String[] excludePath = {"/login","/css/**","*.icon"};

    @Resource
    private AuthInterceptor authInterceptor;

    @Resource
    private CustomInterceptor customInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authInterceptor)
//                .addPathPatterns("/**").excludePathPatterns(excludePath);
        registry.addInterceptor(customInterceptor).addPathPatterns("/check");
    }
}
