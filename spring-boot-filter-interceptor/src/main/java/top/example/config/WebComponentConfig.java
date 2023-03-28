package top.example.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import top.example.web.filter.CustomFilter;

//@Configuration
public class WebComponentConfig {

    @Bean
    public FilterRegistrationBean<?> filterRegistrationBean(){
        FilterRegistrationBean<CustomFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new CustomFilter());
//        filterRegistrationBean.setUrlPatterns(List.of("/*"));
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

}
