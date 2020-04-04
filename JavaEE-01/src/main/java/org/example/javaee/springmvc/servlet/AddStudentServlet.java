package org.example.javaee.springmvc.servlet;

import org.example.javaee.springmvc.jdbc.StudentHomeworkJdbc;
import org.example.javaee.springmvc.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
        PrintWriter out = resp.getWriter();
        out.print("<script>alert('Submit successfully!'); window.location='/TeacherJSP/addStudent.jsp' </script>");

    }
}
