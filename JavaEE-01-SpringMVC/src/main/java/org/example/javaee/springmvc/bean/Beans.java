package org.example.javaee.springmvc.bean;
import org.example.javaee.springmvc.jdbc.StudentHomeworkJdbc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Beans {

    @Bean
    public StudentHomeworkJdbc studentHomeworkJdbc(){
        return new StudentHomeworkJdbc();
    }

}
