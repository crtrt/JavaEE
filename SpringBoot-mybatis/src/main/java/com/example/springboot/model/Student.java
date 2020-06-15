package com.example.springboot.model;

import lombok.Data;
import java.util.Date;


@Data
public class Student {
    private Long id;

    private String name;

    private Date createTime;

    private Date updateTime;

    private String psw;

}
