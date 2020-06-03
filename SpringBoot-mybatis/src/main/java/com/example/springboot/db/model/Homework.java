package com.example.springboot.db.model;

import lombok.Data;
import java.util.Date;


@Data
public class Homework {
    private Long id;

    private String title;
    private String content;

    private Date createTime;
    private Date updateTime;
}
