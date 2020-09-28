package com.hh.userservice.config;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@Aspect
@Component
@Slf4j
public class UserAspect {
    private Logger logger = LoggerFactory.getLogger(UserAspect.class);

    @Pointcut("execution(* com.hh.userservice.controller..*(..))")
    private void pointCut() {}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) {
        Object proceed = null;
        try {
            // 参数的值
            Object[] args = point.getArgs();
            MethodSignature signature = (MethodSignature) point.getSignature();
            Method method = signature.getMethod();
            // 参数的名称
            Parameter[] parameters = method.getParameters();
            proceed = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }

}
