<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/4/25
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/ss.css">
    <title>创建课程</title>
</head>
<body>
<div class="top">
    <div class="top-left"><a href="#">红博文化学校</a></div>
    <a href="/admin/logOut" id="goback">
        <div class="trangle1"></div>
        <div class="juxing1">退出</div>
    </a>
</div>

<div class="mid-left">
    <img src="../../img/创建.png" >
    <a href="/admin/opCourse" class="form1">课程管理</a>
</div>
<div class="mid-left">
    <img src="../../img/学生.png" >
    <a href="/admin/stuTable" class="form1">学生表</a>
</div>
<div class="mid-left">
    <img src="../../img/教师.png" >
    <a href="/admin/teaTable" class="form1">教师表</a>
</div>
<div class="mid-left">
    <img src="../../img/管理.png" >
    <a href="/admin/upCourse" class="form1">课程修改</a>
</div>
<div class="mid-left">
    <img src="../../img/创建.png" >
    <a href="/admin/goStuUpdate" class="form1">学生修改</a>
</div>
<div class="mid-left">
    <img src="../../img/管理.png" >
    <a href="/admin/goTeaUpdate" class="form1">教师修改</a>
</div>
<div class="mid-left">
    <img src="../../img/创建.png" >
    <a href="/admin/createCourse" class="form1 act">创建课程</a>
</div>
<div class="left-finsh"></div>

<div class="home">
    <img src="../../img/home.png" >
    <div>我的桌面</div>
</div>

<form action="/admin/doCreateCourse" class="createClass">
    <h1>创建课程首页</h1>
    <div class="createClass-div">
        <p>课名</p>
        <input type="text" name="name" class="s1"/>
    </div>

    <div class="createClass-div">
        <p>教师</p>
        <input type="text" name="tName" class="s1"/>
    </div>
    <div class="createClass-div">
        <p>教师号</p>
        <input type="text" name="tId" class="s1"/>
    </div>
    <div class="createClass-div">
        <p>学生费</p>
        <input type="text" name="sPay" class="s1"/>
    </div>
    <div class="createClass-div">
        <p>教师费</p>
        <input type="text" name="tPay" class="s1"/>
    </div>

    <div class="createClass-div">
        <p>学生人数</p>
        <input type="text" name="number" class="s1"/>
    </div>
    <div class="createClass-div">
        <p>上课时间</p>
        <input type="text" name="time" class="s1"/>
    </div>
    <div class="createClass-div">

        <input type="submit" value="完成创建" class="s1 s3"/>
    </div>

</form>

</body>
</html>

