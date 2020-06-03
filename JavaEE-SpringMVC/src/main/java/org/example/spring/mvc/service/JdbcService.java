package org.example.spring.mvc.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
//控制层之下，dao之上
@Service
public class JdbcService {
    public void  getById(Long id){
        System.out.println("getById("+id+")");

    }
}
