package org.example.javaee.springmvc.controller;

import org.example.javaee.springmvc.bean.Beans;
import org.example.javaee.springmvc.jdbc.StudentHomeworkJdbc;
import org.example.javaee.springmvc.model.Homework;
import org.example.javaee.springmvc.model.Student;
import org.example.javaee.springmvc.model.StudentHomework;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.Date;

@RequestMapping("/TeacherJSP/")
@Controller
public class teacherController {

    public StudentHomeworkJdbc getStudentHomeworkJdbc(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        StudentHomeworkJdbc studentHomeworkJdbc=(StudentHomeworkJdbc) context.getBean("studentHomeworkJdbc");
        return  studentHomeworkJdbc;
    }

    @RequestMapping(value = "AddStudentServlet")
    public  String addStudent(@RequestBody Student sh){
        //获取当前时间
        Timestamp now = new Timestamp(new Date().getTime());
        /**
         * 赋值
         */
        sh.setCreateTime(now);
        getStudentHomeworkJdbc().addStudent(sh);
        return "/TeacherJSP/addStudent.jsp";
    }

    @RequestMapping(value = "AddHomeworkServlet")
    public  String addHomework(@RequestBody Homework sh){
        //获取当前时间
        Timestamp now = new Timestamp(new Date().getTime());
        /**
         * 赋值
         */
        sh.setCreateTime(now);
        getStudentHomeworkJdbc().addStudentHomework(sh);

        return "/TeacherJSP/addHomework.jsp";
    }


    @RequestMapping(value = "SubmitScore")
    public  String updateHomework(@RequestBody StudentHomework sh){
        //获取当前时间
        Timestamp now = new Timestamp(new Date().getTime());
        /**
         * 赋值
         */
        sh.setSetScoreTime(now);

        getStudentHomeworkJdbc().submitScore(sh);

        return "/TeacherJSP/readHomework.jsp";
    }


}
