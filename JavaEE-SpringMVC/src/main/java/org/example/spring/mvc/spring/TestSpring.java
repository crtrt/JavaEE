package org.example.spring.mvc.spring;

import org.example.spring.mvc.aspect.TestAspect;
import org.example.spring.mvc.service.JdbcService;
import org.springframework.context.annotation.*;

@ComponentScan("org.example.spring.mvc.*")
@EnableAspectJAutoProxy
public class TestSpring {
    public static void main(String[] args){

        //1
//        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        //2
//        ApplicationContext context = new FileSystemXmlApplicationContext("JavaEE-SpringMVC/src/resources/app-context.xml");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestSpring.class);

        TestAspect testAspect=context.getBean("testAspect", TestAspect.class);

        System.out.println(testAspect.toString());

        JdbcService jdbcService=context.getBean("jdbcService", JdbcService.class);

        jdbcService.getById(10L);

//        context.scan("org.example.spring.mvc.service.*");




//
//        int n=1;
//        while (n-->=0){

            //getById
//           TestBean service = context.getBean("testBean2",TestBean.class);
            //getByName
//            TestBean service=(TestBean) context.getBean("testBean2");
//            System.out.println(service.toString());
        //    输出 org.example.spring.mvc.bean.TestBean@2cd76f31

//
//            JdbcService jdbcService = context.getBean("jdbcService",JdbcService.class);
//
//            jdbcService.getById(100L);
//        }

    }
}
