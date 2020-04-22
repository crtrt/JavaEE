package org.example.spring.mvc.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
////类
//@Component
//方法
@Configuration

public class TestBean {
    private  Long id;
    String Test;

    private String name;

    @Bean(name="testBean2")
    public TestBean testBean2(){
        return new TestBean(1L,"init name");
    }

    public TestBean() {
    }

    @Override
    public String toString() {
        return "Test"+
                "id= "+id+
                "  name= "+ name;
    }

    public TestBean(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
