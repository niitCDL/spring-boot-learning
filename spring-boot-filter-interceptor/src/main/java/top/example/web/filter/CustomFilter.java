package top.example.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = {"/*"})
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("----------filter 初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException{
        log.info("----------filter放行之前");
        filterChain.doFilter(servletRequest,servletResponse);
        log.info("----------filter放行之后");
    }

    @Override
    public void destroy() {
        log.info("----------filter 销毁");
    }
}
