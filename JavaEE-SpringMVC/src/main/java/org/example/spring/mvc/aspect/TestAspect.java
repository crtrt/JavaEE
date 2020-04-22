package org.example.spring.mvc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * aspect:  切面 针对业务
 * Pointcut切点：表达式 execution（）  execution spring aop
 */
@Aspect
@Component
public class TestAspect {

    @Pointcut("execution(* org.example.spring.mvc.service.*.*(..))")
    public void service(){

    }
    //Advice
    @Before("service()")
    public void beforeService(){
        System.out.println("berfore");
    }

    @After("service()")
    public void afterService(){
        System.out.println("after");
    }

    //before after
    @Around("service()")
    public Object aroundService(ProceedingJoinPoint jp){
        Object object=null;
        try{
            System.out.println("before around");
            //让jdbcservice 执行getbyid
            object=jp.proceed();
            //请求参数，日志输出
            System.out.println("After around");
        }catch(Throwable throwable){
            throwable.printStackTrace();
        }
        return object;
    }


}
