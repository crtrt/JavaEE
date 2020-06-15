package com.example.springboot.service;

import com.example.springboot.mapper.HomeworkMapper;
import com.example.springboot.model.Homework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
public class HomeworkService  {
    @Autowired
    private HomeworkMapper mapper;
    @Transactional
    public List<Homework> selectHomework(){
        return mapper.selectHomework();
    }

    @Transactional
    public void addStudentHomework(Homework hw){
        mapper.addStudentHomework(hw);
    }
}
