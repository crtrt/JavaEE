package org.example.javaee.springmvc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * aspect:  切面 针对业务
 * Pointcut切点：表达式 execution（）  execution spring aop
 */
@Aspect
@Component
public class aspect {

    /**
     * 横切所有controller下的方法
     */
    @Pointcut("execution(* org.example.javaee.springmvc.controller*.*(..))")
    public void controllerPointCut(){}

    /**
     * 横切所有jdbc下的方法
     */
    @Pointcut("execution(* org.example.javaee.springmvc.jdbc*.*(..))")
    public void jdbcPointCut(){}

    /**
     * 环绕通知
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("controllerPointCut()")
    public Object aroundController(ProceedingJoinPoint  jp) throws Throwable{
        Object object=null;
        String str = "controller:" + jp.toString() + "\n" ;
        System.out.println(str);
        return object;
    }


    @Before("controllerPointCut()" )
    public void beforeController(ProceedingJoinPoint joinPoint) {
        String str = "controller before~";
        System.out.println(str);
    }

    @Around("jdbcPointCut()")
    public Object aroundJdbc(ProceedingJoinPoint  jp) throws Throwable{
        Object object=null;
        String str = "jdbc:" + jp.toString() + "\n" ;
        System.out.println(str);
        return object;
    }


    @Before("jdbcPointCut()" )
    public void beforeJdbc(ProceedingJoinPoint joinPoint) {
        String str = "jdbc before~";
        System.out.println(str);
    }
}
