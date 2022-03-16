package com.example.AOPDemo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect
public class MyAspect {

    @Pointcut("execution(* com.example.AOPDemo.*.*(..))")
    private void pointcut() {
    };

    @Before("pointcut()")
    public void before() {
        System.out.println("Julie's parents say: \"We need to investigate this boy first.\"");
    }

    @AfterReturning("pointcut()")
    public void afterReturning() {
        System.out.println("Julie's parents ask: \"What do you think of him?\"");
    }

    // * Proceeding Joinpoint 正在执行的连接点 === 切点
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("Julie's parents say: \"Remember to be polite.\"");
        Object proceed = point.proceed();
        System.out.println("Julie's parents ask: \"How was the date going?\"");
        return proceed;
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("Whaaaaaat happened?!");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("No matter what happened, let's sleep first.");
    }
}
