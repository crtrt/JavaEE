package com.example.springcloudnetflixzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class SpringCloudNetflixZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudNetflixZuulApplication.class, args);
    }

}
