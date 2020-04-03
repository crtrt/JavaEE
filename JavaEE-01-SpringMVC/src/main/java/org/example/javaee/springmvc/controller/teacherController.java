package org.example.javaee.springmvc.controller;

import org.example.javaee.springmvc.jdbc.StudentHomeworkJdbc;
import org.example.javaee.springmvc.model.Homework;
import org.example.javaee.springmvc.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

@RequestMapping("/TeacherJSP/")
@Controller
public class teacherController {

    @RequestMapping(value = "AddStudentServlet",method = RequestMethod.POST)
    public  String addStudent(HttpServletRequest req, HttpServletResponse resp){
        Student sh = new Student();
        //获取当前时间
        Timestamp now = new Timestamp(new Date().getTime());
        /**
         * 赋值
         */
        sh.setId(Long.parseLong(req.getParameter("id")));
        sh.setName(req.getParameter("name"));
        sh.setCreateTime(now);
        StudentHomeworkJdbc.addStudent(sh);
        return "/TeacherJSP/addStudent.jsp";
    }

    @RequestMapping(value = "AddHomeworkServlet",method = RequestMethod.POST)
    public  String addHomework(HttpServletRequest req, HttpServletResponse resp){

        Homework sh = new Homework();
        //获取当前时间
        Timestamp now = new Timestamp(new Date().getTime());
        /**
         * 赋值
         */
        sh.setTitle(req.getParameter("title"));
        sh.setContent(req.getParameter("content"));
        sh.setCreateTime(now);
        StudentHomeworkJdbc.addStudentHomework(sh);

        return "/TeacherJSP/addHomework.jsp";
    }




}
