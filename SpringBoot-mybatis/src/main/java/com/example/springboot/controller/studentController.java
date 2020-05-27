package com.example.springboot.controller;


import com.example.springboot.db.model.StudentHomework;
import com.example.springboot.db.service.StudentHomeworkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/StudentJSP/")
@RestController
public class studentController {

    private final StudentHomeworkService studentHomeworkService;


    public studentController(StudentHomeworkService studentHomeworkService) {
        this.studentHomeworkService = studentHomeworkService;
    }

    /**
     * 提交作业
     * @param studentHomework
     * @return
     */

    @RequestMapping(value = "SubmitHomeworkServlet",method = RequestMethod.POST)
    public StudentHomework addStudentHomework(@RequestBody StudentHomework studentHomework){
        //获取当前时间
        Timestamp now = new Timestamp(new Date().getTime());
        /**
         * 赋值
         */
        studentHomework.setCreateTime(now);
        studentHomeworkService.submitHomework(studentHomework);
        return null;
    }


    /**
     * 删除选中记录
     * @param studentHomework
     * @return
     */
//    @RequestMapping(value = "deleteServlet")
//    public  String delectHomework(HttpServletRequest req, HttpServletResponse resp){
//        /**
//         * 赋值
//         */
//        String[] selectdelete = req.getParameterValues("chk");
//
//        if(selectdelete!=null){
//
//            String ids ="";
//            for(int i=0;i<selectdelete.length;i++){
//                ids += "'"+selectdelete[i]+"'";
//                if(i!=selectdelete.length-1) ids+=",";
//            }
//
//            studentHomeworkJdbc.deleteHomework(ids);
//            return "/StudentJSP/subHomework.jsp";
//        }else{
//            return "/StudentJSP/subHomework.jsp";
//        }
//    }
//
//    @RequestMapping(value = "deleteServlet",method = RequestMethod.POST)
//    public StudentHomework delectHomework(@RequestBody StudentHomework studentHomework){
//
//        studentHomeworkService.getMapper().deleteById(studentHomework.getId());
//        return null;
//    }
//
//
//    /**
//     * 修改作业
//     * @param studentHomework
//     * @return
//     */
//
//    @RequestMapping(value = "updateServlet",method = RequestMethod.POST)
//    public StudentHomework updateHomework(@RequestBody StudentHomework studentHomework){
//        //获取当前时间
//        Timestamp now = new Timestamp(new Date().getTime());
//        /**
//         * 赋值
//         */
//        studentHomework.setUpdateTime(now);
//        studentHomeworkService.getMapper().save(studentHomework);
//        return null;
//    }



}
