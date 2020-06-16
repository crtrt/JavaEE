package com.example.springboot.controller;

import com.example.springboot.model.StudentHomework;
import com.example.springboot.service.HomeworkService;
import com.example.springboot.service.StudentHomeworkService;
import com.example.springboot.model.Student;
import com.example.springboot.model.Homework;
import com.example.springboot.service.StudentService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@Controller
public class teacherController {
    @Autowired
    private final StudentHomeworkService studentHomeworkService;
    @Autowired
    private final StudentService studentService;
    @Autowired
    private final HomeworkService homeworkService;

    public teacherController(StudentHomeworkService studentHomeworkService, StudentService studentService, HomeworkService homeworkService) {
        this.studentHomeworkService = studentHomeworkService;
        this.studentService = studentService;
        this.homeworkService = homeworkService;
    }
//    @RequestMapping(value = "index")
//    public  String login(){
//        return  "index";
//    }
    /**
     * 添加学生
     * @param sh
     * @return
     */

    @RequestMapping(value = "AddStudentServlet",method = RequestMethod.POST)
    public String addStudent(@ModelAttribute  Student sh){
        //获取当前时间
        Timestamp now = new Timestamp(new Date().getTime());

        sh.setCreate_time(now);

        studentService.addStudent(sh);

        return  "redirect:/addStudent";
    }

    /**
     * 添加作业
     * @param sh
     * @return
     */

    @RequestMapping(value = "AddHomeworkServlet",method = RequestMethod.POST)
    public  String addHomework(@ModelAttribute Homework sh){
        //获取当前时间
        Timestamp now = new Timestamp(new Date().getTime());

        sh.setCreate_time(now);

        homeworkService.addStudentHomework(sh);

        return  "redirect:/addHomework";
    }

    /**
     * 提交成绩
     * @param sh
     * @return
     */
    @RequestMapping(value = "SubmitScore",method = RequestMethod.POST)
    public  String updateHomework(@ModelAttribute  StudentHomework sh){
        //获取当前时间
        Timestamp now = new Timestamp(new Date().getTime());

        sh.setSet_score_time(now);

        studentHomeworkService.submitScore(sh);

        return  "redirect:/readHomework";
    }

    /**
     * 查看所有作业与答案
     * @param model
     * @return
     */
    @RequestMapping("/readHomework")
    public String student(Model model) {

        List<StudentHomework> list = studentHomeworkService.selectAll();

        model.addAttribute("list",list);

        return "/readHomework";
    }

    /**
     * 查看所有老师发布的作业
     * @param model
     * @return
     */
    @RequestMapping("/addHomework")
    public String selectHomework(Model model) {

        List<Homework> list = homeworkService.selectHomework();

        model.addAttribute("list",list);

        return "/addHomework";
    }


    /**
     * 查看所有学生
     * @param model
     * @return
     */
    @RequestMapping("/addStudent")
    public String selectStudent(Model model) {

        List<Student> list = studentService.selectStudent();

        model.addAttribute("list",list);

        return "/addStudent";
    }

}
