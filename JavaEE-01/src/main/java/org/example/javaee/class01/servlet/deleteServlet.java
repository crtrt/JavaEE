package org.example.javaee.class01.servlet;

import org.example.javaee.class01.jdbc.StudentHomeworkJdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 赋值
         */
        String[] selectdelete = req.getParameterValues("chk");
        PrintWriter out = resp.getWriter();
        if(selectdelete!=null){

        String ids ="";
        for(int i=0;i<selectdelete.length;i++){
            ids += "'"+selectdelete[i]+"'";
            if(i!=selectdelete.length-1) ids+=",";
        }

        StudentHomeworkJdbc.deleteHomework(ids);
        out.print("<script>alert('Delete successfully!'); window.location='/StudentJSP/subHomework.jsp' </script>");
    }else{
            out.print("<script>alert('You should select one item at least!'); window.location='/StudentJSP/subHomework.jsp' </script>");
        }
    }
}