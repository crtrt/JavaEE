<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: enovo
  Date: 2020/3/8
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>欢迎</title>
  </head>
  <body>

  <div id="frame">
        <p style="font-size: 28px">作业管理系统</p>

          <form name="form1" action="" method="post" >
              <p><label style="margin-top: 8px" class="label_input">账号</label><input style="margin-top: 8px" type="text" name="id" class="text_field"/></p>
              <p><label class="label_input">密码</label><input type="text" name="psw" class="text_field"/></p>
              <div id="control">
                  <input type="submit" id="t_btn_login" value="教师登录" onclick = "form1.action='teacherLogin';form1.submit()"/>
                  <input type="submit" id="s_btn_login" value="学生登录" onclick = "form1.action='studentLogin';form1.submit()"/>
              </div>
          </form>

、
  </div>

  </body>
</html>


<style>
  body {
    background-image: url("../../images/6.jpg");;
    background-size: 100%;
    background-repeat: no-repeat;
      color: #1e704d;
  }

  #frame {
    width: 400px;
    height: 260px;
    padding: 13px;
    position: absolute;
    left: 50%;
    top: 60%;
    margin-left: -200px;
    margin-top: -200px;
    background-color: rgba(240, 255, 255, 0.6);
    text-align: center;
  }

  #t_btn_login {
    margin-top: 20px;
    font-size: 16px;
    font-family: 宋体;
    width: 120px;
    height: 32px;
    line-height: 32px;
    text-align: center;
      color: #1e704d;
      background-color: #d5f1e5;
    border-radius: 6px;
    border: 0;
    float: left;
     margin-left: 30px;

  }

  #s_btn_login{
    margin-top: 20px;
    font-size: 16px;
    font-family: 宋体;
    width: 120px;
    height: 32px;
    line-height: 32px;
    text-align: center;
      color: #1e704d;
      background-color: #d5f1e5;
    border-radius: 6px;
    border: 0;
    float: right;
    margin-right: 30px;

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



</style>