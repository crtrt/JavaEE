package com.example.springboot.model;

import lombok.Data;

import java.util.Date;


@Data
public class Teacher {
    private Long id;

    private String name;

    private Date createTime;

    private Date updateTime;

    private String psw;

}
