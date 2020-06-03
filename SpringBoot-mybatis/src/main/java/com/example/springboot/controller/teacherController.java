package com.example.springboot.controller;

import com.example.springboot.db.model.StudentHomework;
import com.example.springboot.db.service.HomeworkService;
import com.example.springboot.db.service.StudentHomeworkService;
import com.example.springboot.db.model.Student;
import com.example.springboot.db.model.Homework;
import com.example.springboot.db.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("/TeacherJSP/")
@RestController
public class teacherController {

    private final StudentHomeworkService studentHomeworkService;
    private final StudentService studentService;
    private final HomeworkService homeworkService;

    public teacherController(StudentHomeworkService studentHomeworkService, StudentService studentService, HomeworkService homeworkService) {
        this.studentHomeworkService = studentHomeworkService;
        this.studentService = studentService;
        this.homeworkService = homeworkService;
    }


    /**
     * 添加学生
     * @param sh
     * @return
     */

    @RequestMapping(value = "AddStudentServlet",method = RequestMethod.POST)
    public String addStudent(@RequestBody  Student sh){
        //获取当前时间
        Timestamp now = new Timestamp(new Date().getTime());

        sh.setCreateTime(now);

        studentService.addStudent(sh);

        return null;
    }

    /**
     * 添加作业
     * @param sh
     * @return
     */

    @RequestMapping(value = "AddHomeworkServlet",method = RequestMethod.POST)
    public  String addHomework(@RequestBody Homework sh){
        //获取当前时间
        Timestamp now = new Timestamp(new Date().getTime());

        sh.setCreateTime(now);

        homeworkService.addStudentHomework(sh);

        return null;
    }

//    /**
//     * 提交成绩，有问题
//     * @param sh
//     * @return
//     */
//    @RequestMapping(value = "SubmitScore",method = RequestMethod.POST)
//    public  String updateHomework(@RequestBody  StudentHomework sh){
//        //获取当前时间
//        Timestamp now = new Timestamp(new Date().getTime());
//
//        sh.setSetScoreTime(now);
//
//       // studentHomeworkJdbc.submitScore(sh);
//
//        studentHomeworkService.getMapper().save(sh);
//
//        return null;
//    }


    /**
     * 展示所有的学生作业
     */
    @RequestMapping("/readHomework")
    public void student(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<StudentHomework> list = studentHomeworkService.selectAll();

        req.setAttribute("list",list);

        req.getRequestDispatcher("/readHomework.jsp").forward(req,resp);
    }

}
