package org.example.javaee.springmvc.bean;

import org.example.javaee.springmvc.jdbc.DatabasePool;
import org.example.javaee.springmvc.jdbc.StudentHomeworkJdbc;
import org.example.javaee.springmvc.model.Homework;
import org.example.javaee.springmvc.model.Student;
import org.example.javaee.springmvc.model.StudentHomework;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class Beans {

    @Bean
    public StudentHomeworkJdbc studentHomeworkJdbc(){
        return new StudentHomeworkJdbc();
    }

    @Bean
    public DatabasePool databasePool(){
        return new DatabasePool();
    }

}
