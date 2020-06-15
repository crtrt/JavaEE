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

    private Long student_id;

    private Long homework_id;

    private String homework_title;

    private String homework_content;

    private String total_score;

    private  String score;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")

    private Date create_time;

    private Date update_time;

    private Date set_score_time;

}
