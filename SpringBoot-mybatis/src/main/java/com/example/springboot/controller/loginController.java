package com.example.springboot.controller;

import com.example.springboot.model.Student;
import com.example.springboot.model.Teacher;
import com.example.springboot.service.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class loginController {
    @Autowired
    private final StudentHomeworkService studentHomeworkService;
    @Autowired
    private final StudentService studentService;
    @Autowired
    private final HomeworkService homeworkService;
    @Autowired
    private final TeacherService teacherService;


    public loginController(StudentHomeworkService studentHomeworkService, StudentService studentService, HomeworkService homeworkService, TeacherService teacherService) {
        this.studentHomeworkService = studentHomeworkService;
        this.studentService = studentService;
        this.homeworkService = homeworkService;
        this.teacherService = teacherService;
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

//
//    @RequestMapping(value = "SubmitHomeworkServlet",method = RequestMethod.POST)
//    public StudentHomework addStudentHomework(@RequestBody StudentHomework studentHomework){
//        //获取当前时间
//        Timestamp now = new Timestamp(new Date().getTime());
//        /**
//         * 赋值
//         */
//        studentHomework.setCreateTime(now);
//        studentHomeworkService.submitHomework(studentHomework);
//        return null;
//    }

    @RequestMapping(value="/teacherLogin", method = RequestMethod.POST)
    public String teacherLogin(@ModelAttribute Teacher t){
        System.out.println(teacherService.teacherLogin(t));
        if(!teacherService.teacherLogin(t).isEmpty()){
            System.out.println("login successfully");
            return  "redirect:/readHomework";
        }else{
            System.out.println("login fail");
            return  "redirect:/index";
        }
    }


    @RequestMapping(value="/studentLogin", method = RequestMethod.POST)
    public String studentLogin(@ModelAttribute Student s, RedirectAttributes redirectAttributes){

        System.out.println(studentService.studentLogin(s));

        if(!studentService.studentLogin(s).isEmpty()){

            System.out.println("login successfully");

            redirectAttributes.addFlashAttribute("stuId", s.getId());

            return  "redirect:/subHomework";
        }else{

            System.out.println("login fail");

            return  "redirect:/index";
        }

    }


    /**
     * 展示所有的学生作业
     */
//    @RequestMapping("/readHomework")
//    public void student(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("???????????");
//        List<StudentHomework> list = studentHomeworkService.selectAll();
//
//        req.setAttribute("list",list);
//
//        req.getRequestDispatcher("/readHomework.jsp").forward(req,resp);
//    }
}
