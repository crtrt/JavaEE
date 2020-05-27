package com.example.springboot.db.service;

import com.example.springboot.db.mapper.StudentHomeworkMapper;
import com.example.springboot.db.model.StudentHomework;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentHomeworkService  {

    private StudentHomeworkMapper mapper;

    public List<StudentHomework> selectAll(){
        return mapper.selectAll();
    }


    public void submitHomework(StudentHomework studentHomework){
        mapper.submitHomework(studentHomework);
    }
}
