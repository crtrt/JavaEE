package org.example.spring.mvc.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class JdbcService {
    public void  getById(Long id){
        System.out.println("getById("+id+")");

    }
}
