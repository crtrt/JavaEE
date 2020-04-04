package org.example.spring.mvc.spring;

import org.example.spring.mvc.bean.TestBean;
import org.example.spring.mvc.service.JdbcService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.lang.annotation.Annotation;
//@ComponentScan("org.example.spring.mvc.*")

public class TestSpring {
    public static void main(String[] args){

        //1
//        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        //2
//        ApplicationContext context = new FileSystemXmlApplicationContext("JavaEE-SpringMVC/src/resources/app-context.xml");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestBean.class);

//        context.scan("org.example.spring.mvc.service.*");




//
//        int n=1;
//        while (n-->=0){

            //getById
           TestBean service = context.getBean("testBean2",TestBean.class);
            //getByName
//            TestBean service=(TestBean) context.getBean("testBean2");
            System.out.println(service.toString());
        //    输出 org.example.spring.mvc.bean.TestBean@2cd76f31

//
//            JdbcService jdbcService = context.getBean("jdbcService",JdbcService.class);
//
//            jdbcService.getById(100L);
//        }

    }
}
