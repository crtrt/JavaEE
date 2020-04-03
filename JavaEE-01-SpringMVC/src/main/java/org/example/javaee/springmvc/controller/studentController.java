package org.example.javaee.springmvc.controller;
import org.example.javaee.springmvc.jdbc.StudentHomeworkJdbc;
import org.example.javaee.springmvc.model.Student;
import org.example.javaee.springmvc.model.StudentHomework;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

@RequestMapping("/StudentJSP/")
@Controller
public class studentController {

    @RequestMapping(value = "SubmitHomeworkServlet",method = RequestMethod.POST)
    public  String addHomework(HttpServletRequest req, HttpServletResponse resp){
        StudentHomework sh = new StudentHomework();
        //获取当前时间
        Timestamp now = new Timestamp(new Date().getTime());
        /**
         * 赋值
         */
        sh.setStudentId(Long.parseLong(req.getParameter("student_id")));
        sh.setHomeworkId(Long.parseLong(req.getParameter("homework_id")));
        sh.setHomeworkTitle(req.getParameter("homework_title"));
        sh.setHomeworkContent(req.getParameter("homework_content"));
        sh.setCreateTime(now);
        StudentHomeworkJdbc.submitHomework(sh);
        return "/StudentJSP/subHomework.jsp";
    }

    @RequestMapping(value = "deleteServlet",method = RequestMethod.POST)
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

            StudentHomeworkJdbc.deleteHomework(ids);
            return "/StudentJSP/subHomework.jsp";
        }else{
            return "/StudentJSP/subHomework.jsp";
        }
    }

    @RequestMapping(value = "updateServlet",method = RequestMethod.POST)
    public  String updateHomework(HttpServletRequest req, HttpServletResponse resp){
        StudentHomework sh = new StudentHomework();
        //获取当前时间
        Timestamp now = new Timestamp(new Date().getTime());
        /**
         * 赋值
         */
        sh.setId(Long.parseLong(req.getParameter("id")));
        sh.setHomeworkTitle(req.getParameter("title"));
        sh.setHomeworkContent(req.getParameter("content"));
        sh.setUpdateTime(now);
        StudentHomeworkJdbc.updateHomework(sh);

        return "/StudentJSP/subHomework.jsp";
    }




}
