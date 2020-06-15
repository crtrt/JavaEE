package com.example.springboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentHomework {
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
