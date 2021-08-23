package com.hh.userservice.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    long start = 0;

    @Pointcut("execution(* com.hh.userservice.controller..*.*(..))")
    public void pointCut() {}

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        start = System.currentTimeMillis();
        System.out.println("开始调用：" + joinPoint.getSignature().getName());
    }

    @After(value = "pointCut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("开始调用：" + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterReturning(JoinPoint joinPoint, String result) {
        for (int i = 0; i < joinPoint.getArgs().length; i++) {
            Object arg = joinPoint.getArgs()[i];
            System.out.println(arg);
        }
        System.out.println("方法结束后的返回值 -> " + result + " 总耗时：" + (System.currentTimeMillis() - start) + "毫秒");
    }
}
