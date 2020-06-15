package com.example.springboot.controller;
import com.example.springboot.model.StudentHomework;
import com.example.springboot.service.StudentHomeworkService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Date;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class studentController {
    @Autowired
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
