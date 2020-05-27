package com.example.springboot.db.service;

import com.example.springboot.db.mapper.HomeworkMapper;
import com.example.springboot.db.mapper.StudentHomeworkMapper;
import com.example.springboot.db.model.Homework;
import com.example.springboot.db.model.StudentHomework;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HomeworkService  {

    private HomeworkMapper mapper;

    public List<Homework> selectHomework(){
        return mapper.selectHomework();
    }


    public void addStudentHomework(Homework hw){
        mapper.addStudentHomework(hw);
    }
}
