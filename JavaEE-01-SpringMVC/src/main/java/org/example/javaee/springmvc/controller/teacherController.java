package org.example.javaee.springmvc.controller;


import org.example.javaee.springmvc.bean.Beans;
import org.example.javaee.springmvc.jdbc.StudentHomeworkJdbc;
import org.example.javaee.springmvc.model.Homework;
import org.example.javaee.springmvc.model.Student;
import org.example.javaee.springmvc.model.StudentHomework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Timestamp;
import java.util.Date;

@RequestMapping("/TeacherJSP/")
@Controller
public class teacherController {
    @Autowired
    private StudentHomeworkJdbc studentHomeworkJdbc;


    @RequestMapping(value = "AddStudentServlet",method = RequestMethod.POST)
    public String addStudent(@ModelAttribute  Student sh){
        //获取当前时间
        Timestamp now = new Timestamp(new Date().getTime());
        /**
         * 赋值
         */
        sh.setCreateTime(now);
        studentHomeworkJdbc.addStudent(sh);
        return "/TeacherJSP/addStudent.jsp";
    }

    @RequestMapping(value = "AddHomeworkServlet",method = RequestMethod.POST)
    public  String addHomework(@ModelAttribute Homework sh){
        //获取当前时间
        Timestamp now = new Timestamp(new Date().getTime());
        /**
         * 赋值
         */
        sh.setCreateTime(now);
        studentHomeworkJdbc.addStudentHomework(sh);

        return "/TeacherJSP/addHomework.jsp";
    }


    @RequestMapping(value = "SubmitScore",method = RequestMethod.POST)
    public  String updateHomework(@ModelAttribute  StudentHomework sh){
        //获取当前时间
        Timestamp now = new Timestamp(new Date().getTime());
        /**
         * 赋值
         */
        sh.setSetScoreTime(now);

        studentHomeworkJdbc.submitScore(sh);

        return "/TeacherJSP/readHomework.jsp";
    }


}
