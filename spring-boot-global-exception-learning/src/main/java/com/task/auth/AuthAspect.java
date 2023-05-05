package com.task.auth;

import com.task.enums.CustomExceptionType;
import com.task.exception.CustomException;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class AuthAspect {

    @Autowired
    private HttpServletRequest request;

    @Around("@annotation(com.task.auth.CheckAuth)")
    public Object checkAuth(ProceedingJoinPoint point) throws Throwable{
        String token = request.getHeader("Authorization");
        if (token == null){
            throw new CustomException(CustomExceptionType.UNAUTHORIZED_ERROR);
        }

        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();
        CheckAuth annotation = method.getAnnotation(CheckAuth.class);
        String value = annotation.value();

        if (!value.equals(token)){
            throw new CustomException(CustomExceptionType.UNAUTHORIZED_ERROR);
        }
        return point.proceed();
    }
}
