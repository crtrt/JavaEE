package com.example.springboot.db.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Data
@Entity
@Table(name = "s_student")
public class Student {
    @Id
    private Long id;

    private String name;

    private Date createTime;

    private Date updateTime;

}
