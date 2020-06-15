package com.example.springboot.service;


import com.example.springboot.mapper.TeacherMapper;
import com.example.springboot.model.Student;
import com.example.springboot.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class TeacherService {
    @Autowired
    private TeacherMapper mapper;
    @Transactional
    public List<Teacher> teacherLogin(Teacher t){
        return mapper.teacherLogin(t);
    }
}
