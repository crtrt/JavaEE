package org.example.javaee.springmvc.controller;

import org.example.javaee.springmvc.bean.Beans;
import org.example.javaee.springmvc.jdbc.StudentHomeworkJdbc;
import org.example.javaee.springmvc.model.StudentHomework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.Date;

@RequestMapping("/StudentJSP/")
@Controller
public class studentController {
    //通过注入
    @Autowired
    private StudentHomeworkJdbc studentHomeworkJdbc;

    @RequestMapping(value = "SubmitHomeworkServlet",method = RequestMethod.POST)
    public  String addHomework(@ModelAttribute  StudentHomework sh){
        //获取当前时间
        Timestamp now = new Timestamp(new Date().getTime());
        /**
         * 赋值
         */
        sh.setCreateTime(now);
        studentHomeworkJdbc.submitHomework(sh);
        return "/StudentJSP/subHomework.jsp";
    }

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

            studentHomeworkJdbc.deleteHomework(ids);
            return "/StudentJSP/subHomework.jsp";
        }else{
            return "/StudentJSP/subHomework.jsp";
        }
    }

    @RequestMapping(value = "updateServlet",method = RequestMethod.POST)
    public  String updateHomework(@ModelAttribute StudentHomework sh){
        //获取当前时间
        Timestamp now = new Timestamp(new Date().getTime());
        /**
         * 赋值
         */
        sh.setUpdateTime(now);
        studentHomeworkJdbc.updateHomework(sh);

        return "/StudentJSP/subHomework.jsp";
    }

}
