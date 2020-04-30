
<%@ page import="java.util.List" %>
<%@ page import="org.example.javaee.springmvc.model.Homework" %>
<%@ page import="org.example.javaee.springmvc.jdbc.StudentHomeworkJdbc" %>
<%@ page import="org.example.javaee.springmvc.model.Student" %>
<%@ page import="org.springframework.context.annotation.AnnotationConfigApplicationContext" %>
<%@ page import="org.example.javaee.springmvc.bean.Beans" %>

<%--
  Created by IntelliJ IDEA.
  User: enovo
  Date: 2020/3/8
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>提交作业</title>
    <%
        Long param = (Long)request.getAttribute("student_id");
    %>
</head>
<body>
<a href="../index.jsp" style="color: #1e704d;float:right">返回首页</a>
<div id="frame">
<%--    <form action="../SubmitHomeworkServlet" method="post" >--%>
        <form name="form1" action="" method="post" >
       <%
           AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
           StudentHomeworkJdbc studentHomeworkJdbc=(StudentHomeworkJdbc) context.getBean("studentHomeworkJdbc");

           List<Homework> homeworklist = studentHomeworkJdbc.selectHomework();
           List<Student> studentlist = studentHomeworkJdbc.selectStudent();
       %>

        <p><label style="margin-top: 20px" class="label_input">个人信息</label>
            <select id="studentId" name="studentId" style="margin-top: 20px" class="select">
                <%
                    for (Student sh : studentlist){
                %>
                <option value="<%=sh.getId()%>">学号:<%=sh.getId()%>        姓名:<%=sh.getName()%></option>
                <%
                    }
                %>
            </select>
        </p>
        <p><label style="margin-top: 20px" class="label_input">选择作业</label>
            <select  name="homeworkId" style="margin-top: 20px" class="select">
                <%
                     for (Homework sh : homeworklist){
                 %>
                <option value="<%=sh.getId()%>">作业<%=sh.getId()%>       题目:<%=sh.getTitle()%>       内容:<%=sh.getContent()%>         总分:<%=sh.getTotal_score()%></option>
                <%
                    }
                %>
             </select>
        </p>


        <p><label style="margin-top: 20px" class="label_input">作业标题</label><input style="margin-top: 20px" type="text" name="homeworkTitle" class="text_field"/></p>
        <p><label style="margin-top: 20px" class="label_input">作业内容</label><input style="margin-top: 20px" type="text" name="homeworkContent" class="text_field"/></p>
        <div id="control" >
<%--            <input style="margin-top: 20px" type="submit" id="btn" value="确认" />--%>
            <input style="margin-top: 20px" class="btn" type="button" value="确认提交" type="submit" onclick="form1.action='SubmitHomeworkServlet';form1.submit();"/>
            <input style="margin-top: 20px" class="btn" type="button" value="查询作业" type="submit" onclick="form1.action='selectMy.jsp';form1.submit();" />
        </div>
    </form>


</div>

</body>
</html>


<style>
body {
    background-image: url("../images/1.jpg");
    background-size: 100%;
    background-repeat: no-repeat;
    font-family: 宋体;
}

#frame {
    width: 800px;
    height: 380px;
    position: absolute;
    padding-top: 13px;
    left: 50%;
    top: 30%;
    margin-left: -400px;
    margin-top: -100px;
    background-color: rgba(240, 255, 255, 0.5);
    border-radius: 10px;
    text-align: center;
}

.btn{
    font-size: 16px;
    font-family: 宋体;
    width: 120px;
    height: 32px;
    line-height: 32px;
    text-align: center;
    color: #1e704d;
    background-color: rgba(240, 255, 255, 0.5);
    border-radius: 6px;
    border: 0;
    margin: auto 0;
}

form p > * {
    display: inline-block;
    vertical-align: middle;
}

.label_input {
    font-size: 16px;
    font-family: 宋体;
    width: 80px;
    height: 32px;
    line-height: 28px;
    text-align: center;
    color: #1e704d;
    background-color: #d5f1e5;
    border-top-left-radius: 5px;
    border-bottom-left-radius: 5px;
}


.text_field {
    width: 278px;
    height: 32px;
    border-top-right-radius: 5px;
    border-bottom-right-radius: 5px;
    border: 0;
}
.select{
    width: 278px;
    height: 32px;
    border-top-right-radius: 5px;
    border-bottom-right-radius: 5px;
    border: 0;
    font-size: 16px;
    font-family: 宋体;
    color: #1e704d;
    padding: 0;
}
</style>