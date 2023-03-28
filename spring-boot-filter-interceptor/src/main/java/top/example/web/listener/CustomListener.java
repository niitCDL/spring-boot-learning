package top.example.web.listener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebListener
public class CustomListener implements ServletContextListener,
        ServletRequestListener, ServletRequestAttributeListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("--------context创建");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("--------context销毁");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        if ("author".equals(srae.getName())) {
            log.info("--------request作用域数据被添加");
        }
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        if ("author".equals(srae.getName()))
            log.info("--------request作用域数据被删除");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        if ("author".equals(srae.getName()))
            log.info("--------request作用域数据被替换");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("--------request销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info("--------request初始化");
    }
}
