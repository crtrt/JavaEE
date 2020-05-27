package com.example.springboot.db.service;

import com.example.springboot.db.mapper.HomeworkMapper;
import com.example.springboot.db.mapper.StudentMapper;
import com.example.springboot.db.model.Homework;
import com.example.springboot.db.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {
    private StudentMapper mapper;

    public List<Student> selectStudent(){
        return mapper.selectStudent();
    }

    public void addStudent(Student s){
        mapper.addStudent(s);
    }
}
