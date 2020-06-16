
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: enovo--%>
<%--  Date: 2020/3/9--%>
<%--  Time: 9:42--%>
<%--  To change this template use File | Settings | File Templates.--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的作业</title>
</head>
<body>
<%String username=request.getParameter("student_id");%>
<%
    out.print("当前学号:"+username);
%>
<a href="/index" style="color: #1e704d;float:right">返回首页</a>
<%--<a href="/subHomework?studentId=${sh.student_id}" style="color: #1e704d;float:right;margin-right: 10px">返回上一页</a>--%>
<form name="form1" action="" method="post" >

    <table style="margin-top: 50px;color:#1e704d;font-family: 宋体; "  align="center" width="1200" border="0.8" bgcolor="#1e704d" cellpadding="1" cellspacing="1" >
        <tr align="center" bgcolor="#d5f1e5"  height="40">
            <td>选择</td>
            <td>ID</td>
            <td>学生学号</td>
            <td>作业编号</td>
            <td>作业标题</td>
            <td>作业内容</td>
            <td>创建时间</td>
            <td>修改时间</td>
            <td>操作</td>
            <td>总成绩</td>
            <td>得分</td>
            <td>批改时间</td>

        </tr>

        <c:forEach items="${list}" var="sh">
            <tr align="center" bgcolor="white" height="30">
                <td><input type="checkbox" name="chk" id="chk" value=${sh.id}></td>

                <td>${sh.id}</td>
                <td>${sh.student_id}</td>
                <td>${sh.homework_id}</td>
                <td>${sh.homework_title}</td>
                <td>${sh.homework_content}</td>
                <td>${sh.create_time}</td>
                <td>${sh.update_time}</td>
                <td><a href="update?id=${sh.id}&studentId=${sh.student_id}&homeworkId=${sh.homework_id}&homeworkTitle=${sh.homework_title}&homeworkContent=${sh.homework_content}">修改</a></td>
                <td>${sh.total_score}</td>
                <td>${sh.score}</td>
                <td>${sh.set_score_time}</td>

            </tr>
        </c:forEach>
    </table>
    <div id="control">
        <input style="margin-top: 20px;margin-left: 550px" class="btn" type="button" value="确认删除" onclick="form1.action='deleteServlet';form1.submit();"/>


    </div>
</form>

</body>
</html>
<style>
    body {
        background-image: url("../../images/1.jpg");
        background-size: 100%;
        background-repeat: no-repeat;
        font-family: 宋体;
        color: #1e704d;
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
        float: left;
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