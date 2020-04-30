package org.example.javaee.springmvc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.example.javaee.springmvc.bean.TransManager;
import org.example.javaee.springmvc.jdbc.DatabasePool;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;


/**
 * aspect:  切面 针对业务
 * Pointcut切点：表达式 execution（）  execution spring aop
 */
@Aspect
@EnableAspectJAutoProxy
@Component
public class MyAspect {

//    /**
//     * 横切所有controller下的方法
//     */
//    @Pointcut("execution(* org.example.javaee.springmvc.controller.*.*(..))")
//    public void controllerPointCut(){}

    /**
     * 横切所有jdbc下的方法
     */

    @Pointcut("execution(* org.example.javaee.springmvc.jdbc.*.*(..))")
    public void jdbcPointCut(){}


//    @Around("controllerPointCut()")
//    public Object aroundController(ProceedingJoinPoint  jp) throws Throwable{
//        Object object=null;
//        System.out.println("before around");
//        //让jdbcservice 执行getbyid
//        object=jp.proceed();
//        //请求参数，日志输出
//        System.out.println("After around");
//        String str = "controller:" + jp.toString() + "\n" ;
//        System.out.println(str);
//        return object;
//    }
//
//
//    @Before("controllerPointCut()" )
//    public void beforeController(ProceedingJoinPoint joinPoint) {
////        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
////        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
////        HttpServletRequest request = sra.getRequest();  //获取request 可以从中获取参数或cookie
//
//        String str = "controller before~";
//        System.out.println(str);
//    }

//    @Around("jdbcPointCut()")
//    public Object aroundJdbc(ProceedingJoinPoint  jp) throws Throwable{
//        Object object=null;
//        String str = "jdbc:" + jp.toString() + "\n" ;
//        System.out.println(str);
//        return object;
//    }


    @Before("jdbcPointCut()" )
    public void beforeJdbc(JoinPoint joinPoint) {
        System.out.println("******拦截前的逻辑******");
        System.out.println("********前置通知********");
        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        //AOP代理类的信息
        joinPoint.getThis();
        //代理的目标对象
        joinPoint.getTarget();
        //用的最多 通知的签名
        Signature signature = joinPoint.getSignature();
        //代理的是哪一个方法
        System.out.println("代理的方法: "+signature.getName());
        //AOP代理类的名字
        System.out.println("AOP代理类: "+signature.getDeclaringTypeName());
        //AOP代理类的类（class）信息
        System.out.println("AOP代理类的类（class）信息: "+signature.getDeclaringType());
        System.out.println("********前置结束********");
    }

    //@AfterReturning注解可以获取方法的返回值，returning的值result代表的就是返回值,形参Object类表示
    @AfterReturning(value="jdbcPointCut()",returning="result")
    public void afterJdbc(java.lang.Object result) {
        System.out.println("******拦截后的逻辑******");
        System.out.println("********后置通知********");
        System.out.println("result："+result.toString());
        System.out.println("********后置结束********");
    }


    @Around("jdbcPointCut()")
    public Object aroundService(ProceedingJoinPoint jp)  {


        Object object = null;

        Connection connection=null;
        try{
            connection = DatabasePool.getHikariDataSource().getConnection();

            connection.setAutoCommit(false);

            System.out.println("#########环绕通知########");

            Signature signature = jp.getSignature();

            System.out.println("目标方法名："+signature.getName());

            TransManager.setConnection(signature.getName(),connection);

            object = jp.proceed();

            connection.commit();

            System.out.println("#########事务提交########");//事务提交

        }catch (Throwable throwable){

            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwable.printStackTrace();//事务回滚
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return object;
    }

}
