
<%@ page import="java.util.List" %>
<%@ page import="com.example.springboot.model.StudentHomework" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
    <title>查询作业</title>
</head>
<body>
    <!-- 引入header.jsp的头部文件 -->
    <%@ include file="header.jsp" %>

    <table style="margin-top: 30px;color:#1e704d;font-family: 宋体; "  align="center" width="1200" border="0.8" bgcolor="#1e704d" cellpadding="1" cellspacing="1" >
        <tr align="center" bgcolor="#d5f1e5"  height="40">
            <td>ID</td>
            <td>学生学号</td>
            <td>作业编号</td>
            <td>作业标题</td>
            <td>作业内容</td>
            <td>创建时间</td>
            <td>修改时间</td>
            <td>总分</td>
            <td>得分</td>
            <td>打分时间</td>
            <td>操作</td>

        </tr>

    <c:forEach items="${list}" var="sh">
        <tr align="center" bgcolor="white" height="30">
            <td>${sh.id}</td>
            <td>${sh.studentId}</td>
            <td>${sh.homeworkId}</td>
            <td>${sh.homeworkTitle}</td>
            <td>${sh.homeworkContent}</td>
            <td>${sh.createTime}</td>
            <td>${sh.updateTime}</td>
            <td>${sh.total_score}</td>
            <td>${sh.score}</td>
            <td>${sh.setScoreTime}</td>
            <td>
<%--                <a href="update.jsp?id=<%=sh.getId()%>&stuId=<%=sh.getStudentId()%>&hmwId=<%=sh.getHomeworkId()%>&hmwTitle=<%=sh.getHomeworkTitle()%>&hmwContent=<%=sh.getHomeworkContent()%>">打分</a>--%>
<%--                <a href="update.jsp?id=<%=sh.getId()%>&stuId=<%=sh.getStudentId()%>&hmwId=<%=sh.getHomeworkId()%>&hmwTitle=<%=sh.getHomeworkTitle()%>&hmwContent=<%=sh.getHomeworkContent()%>">修改</a>--%>
<%--                <a href="update.jsp?id=<%=sh.getId()%>&stuId=<%=sh.getStudentId()%>&hmwId=<%=sh.getHomeworkId()%>&hmwTitle=<%=sh.getHomeworkTitle()%>&hmwContent=<%=sh.getHomeworkContent()%>">删除</a>--%>
                <input type="button" value="打分" onclick="openPopup(${sh.id})">
            </td>
        </tr>
    </c:forEach>
    </table>

    <%--div事先存在但被隐藏 --%>
    <div class="type1" id="setScore" style="display: none">
        <font ><b>输入分数</b></font>
        <br>
        <br>
        <form name="form1" action="" method="post">

            <label>*作业号</label><input readOnly="true" type="text" id="id" name="id">
            <br>
            <label> 成绩  </label>
            <input type="text" id="score" name="score">
            <br>
            <input type="button" class="type2" value="取消" onclick="closePopup()">
<%--            <input type="button" class="type2" value="确定" onclick="greet()">--%>
            <input style="margin-top: 20px" class="btn" type="button" value="提交" type="submit" onclick="form1.action='SubmitScore';form1.submit();greet()"/>
        </form>

    </div>



</body>
</html>
<script language="javascript">

    function openPopup(id) {
        //取消div的隐藏
        document.getElementById("setScore").style.display = "block";
        document.getElementById("id").value = id;

    }

    function closePopup() {
        //重新设置隐藏
        document.getElementById("setScore").style.display = "none";
    }

    function greet(){
        document.getElementById("setScore").style.display = "none";
    }
</script>


<style>
    body {
        background-image: url("../../images/5.jpg");
        background-size: 100%;
        background-repeat: no-repeat;
        font-family: 宋体;
    }

    .type1 {
        position: fixed;
        left: 50%;
        top: 50%;
        width: 300px;
        height: 140px;
        padding-top: 20px;
        padding-bottom: 20px;
        margin: -100px 0px 0px -150px;
        border: 5px solid #7d5294;
        background-color: rgba(242, 231, 249,1);
        text-align: center;
    }

    .type2 {
        background-color: rgba(255, 140, 0, 0.1);
        border-style: groove;
        border-color: rgb(242, 231, 249);
    }
    .button{
        font-size: 16px;
        font-family: 宋体;
        text-align: center;
        color: #1e704d;
        background-color: rgba(240, 255, 255, 0.5);
        border-radius: 6px;
        border: 0;
    }

</style>