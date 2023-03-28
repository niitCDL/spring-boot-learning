package top.example.web.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import top.example.web.exception.ParamNotMatchException;
import top.example.web.interceptor.rules.CheckParams;
import top.example.web.interceptor.rules.CheckRule;
import top.example.web.interceptor.rules.CheckType;
import top.example.web.interceptor.rules.utils.ParamCheckUtil;

import java.lang.reflect.Method;

@Component
public class CustomInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            CheckParams checkParams = method.getAnnotation(CheckParams.class);
            if(checkParams == null || StringUtils.isEmpty(checkParams.rules())) {
                return true;
            }
            for (CheckRule rule: checkParams.rules()) {
                String attribute = request.getParameter(rule.attrName());
                boolean b = rule.notNull();
                CheckType type = rule.type();
                String value = rule.value();
                if (!ParamCheckUtil.verifyParam(attribute, b, type, value)) {
                    throw new ParamNotMatchException(ParamNotMatchException.class + " : " + rule.message());
                }
            }
        }
        return true;
    }
}
