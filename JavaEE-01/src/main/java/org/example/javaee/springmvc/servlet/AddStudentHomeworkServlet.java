package org.example.javaee.springmvc.servlet;

import org.example.javaee.springmvc.jdbc.StudentHomeworkJdbc;
import org.example.javaee.springmvc.model.Homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet("/AddStudentHomeworkServlet")
public class AddStudentHomeworkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
        PrintWriter out = resp.getWriter();
        out.print("<script>alert('Submit successfully!'); window.location='/TeacherJSP/addHomework.jsp' </script>");

    }
}
