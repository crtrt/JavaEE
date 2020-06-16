package com.example.springboot.controller;
import com.example.springboot.model.Homework;
import com.example.springboot.model.StudentHomework;
import com.example.springboot.service.HomeworkService;
import com.example.springboot.service.StudentHomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class studentController {
    @Autowired
    private final StudentHomeworkService studentHomeworkService;
    @Autowired
    private final HomeworkService homeworkService;

    public studentController(StudentHomeworkService studentHomeworkService, HomeworkService homeworkService) {
        this.studentHomeworkService = studentHomeworkService;
        this.homeworkService = homeworkService;
    }


    /**
     * 查看所有老师发布的作业
     * @param model
     * @return
     */
    @RequestMapping("/subHomework")
    public String selectHomework(Model model) {

        List<Homework> list = homeworkService.selectHomework();

        model.addAttribute("list",list);

        return "/subHomework";
    }

    /**
     * 提交作业
     * @param studentHomework
     * @return
     */

    @RequestMapping(value = "SubmitHomeworkServlet",method = RequestMethod.POST)
    public String addStudentHomework(@ModelAttribute StudentHomework studentHomework, RedirectAttributes redirectAttributes){
        //获取当前时间
        Timestamp now = new Timestamp(new Date().getTime());

        studentHomework.setCreate_time(now);

        studentHomeworkService.submitHomework(studentHomework);

        redirectAttributes.addFlashAttribute("stuId", studentHomework.getStudent_id());

        return  "redirect:/subHomework";
    }

    /**
     * 查看自己交的作业
     * @param model
     * @return
     */
    @RequestMapping("/selectMy")
    public String selectMy(Model model,@ModelAttribute StudentHomework studentHomework) {

        List<StudentHomework> list = studentHomeworkService.selectMy(studentHomework);

        model.addAttribute("list",list);

        return "/selectMy";
    }


    /**
     * 删除选中记录
     studentHomework   * @param
     * @return
     */
    @RequestMapping(value = "deleteServlet")
    public  String delectHomework(HttpServletRequest req, HttpServletResponse resp){
        /**
         * 赋值
         */
        String[] selectdelete = req.getParameterValues("chk");

        if(selectdelete!=null){

            String ids ="";

            for(int i=0;i<selectdelete.length;i++){
                ids += "'"+selectdelete[i]+"'";
                if(i!=selectdelete.length-1) ids+=",";
            }

            System.out.println(ids);

            studentHomeworkService.deleteHomework(ids);

            return "/index";
        }else{
            return"/index";
        }
    }


    /**
     * 修改作业
     * @param studentHomework
     * @return
     */

    @RequestMapping(value = "updateServlet")
    public String updateHomework(@ModelAttribute StudentHomework studentHomework){
        //获取当前时间
        Timestamp now = new Timestamp(new Date().getTime());
        /**
         * 赋值
         */
        studentHomework.setUpdate_time(now);

        studentHomeworkService.updateHomework(studentHomework);

        return "redirect:/index";
    }

    @RequestMapping("/update")
    public String update() {


        return "/update";
    }

}
