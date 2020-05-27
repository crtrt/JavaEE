package com.example.springboot.db.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "s_student_homework")
public class StudentHomework {
    @Id
    private Long id;

    private Long studentId;

    private Long homeworkId;

    private String homeworkTitle;

    private String homeworkContent;

    private String total_score;

    private  String score;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")

    private Date createTime;

    private Date updateTime;

    private Date setScoreTime;

}
