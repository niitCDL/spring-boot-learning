package top.example.web.interceptor.rules;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckRule {
    String attrName();
    boolean notNull() default false;
    String message() default "参数未通过校验";
    CheckType type();
    String value() default "";
}

