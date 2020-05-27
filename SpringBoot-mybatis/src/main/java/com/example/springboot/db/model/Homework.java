package com.example.springboot.db.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Data
@Entity
@Table(name = "s_homework")
public class Homework {
    @Id
    private Long id;

    private String title;
    private String content;

    private Date createTime;
    private Date updateTime;
}
