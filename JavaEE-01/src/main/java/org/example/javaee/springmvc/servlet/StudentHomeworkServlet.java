package org.example.javaee.springmvc.servlet;

import org.example.javaee.springmvc.jdbc.StudentHomeworkJdbc;
import org.example.javaee.springmvc.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
servlet访问数据库
jsp调用这个servlet
 */
@WebServlet("/list")
public class StudentHomeworkServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<StudentHomework> list = StudentHomeworkJdbc.selectAll();
        req.setAttribute("list", list);
        //把req、resp转发给jsp
        req.getRequestDispatcher("/TeacherJSP/readHomework.jsp").forward(req, resp);
    }

}
