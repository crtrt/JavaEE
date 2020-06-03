package com.example.springboot.db.model;

import lombok.Data;
import java.util.Date;


@Data
public class Student {
    private Long id;

    private String name;

    private Date createTime;

    private Date updateTime;

}
