package com.example.springboot.service;

import com.example.springboot.mapper.StudentHomeworkMapper;
import com.example.springboot.model.Homework;
import com.example.springboot.model.StudentHomework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
public class StudentHomeworkService  {
    @Autowired
    private StudentHomeworkMapper mapper;
    @Transactional
    public List<StudentHomework> selectAll(){
        return mapper.selectAll();
    }
    @Transactional
    public void submitScore(StudentHomework s){
        mapper.submitScore(s);
    }
    @Transactional
    public void addStudentHomework(Homework h){
        mapper.addStudentHomework(h);
    }
    @Transactional
    public void submitHomework(StudentHomework studentHomework){
        mapper.submitHomework(studentHomework);
    }

    @Transactional
    public List<StudentHomework> selectMy(StudentHomework studentHomework){
        return mapper.selectMy(studentHomework);
    }

    @Transactional
    public void deleteHomework(String ids){

        mapper.deleteHomework(ids);
    }

    @Transactional
    public void updateHomework(StudentHomework studentHomework){

        mapper.updateHomework(studentHomework);
    }
}
