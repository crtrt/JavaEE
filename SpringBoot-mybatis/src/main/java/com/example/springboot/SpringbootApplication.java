package com.example.springboot;

import org.mybatis.spring.annotation.MapperScan;import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;import org.springframework.context.annotation.ComponentScan;import org.springframework.context.annotation.ComponentScans;


@ComponentScans(value = { @ComponentScan(value = "com.example.springboot.controller"),
        @ComponentScan(value = "com.example.springboot.service") })

@MapperScan("com.example.springboot.mapper")
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
