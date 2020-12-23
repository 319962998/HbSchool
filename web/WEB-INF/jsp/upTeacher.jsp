<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/5/7
  Time: 1:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>修改教师信息</title>
    <link rel="stylesheet" type="text/css" href="/ss.css"/>
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
    <a href="/admin/goTeaUpdate" class="form1 actw">教师修改</a>
</div>
<div class="mid-left">
    <img src="../../img/创建.png" >
    <a href="/admin/createCourse" class="form1">创建课程</a>
</div>
<div class="left-finsh"></div>

<div class="home">
    <img src="../../img/home.png" >
    <div>我的桌面</div>
</div>
<h1 style="color: #129d90;position: absolute;top: 120px;left: 250px;">教师信息修改</h1>
<form action="/admin/updateTeaSerch" class="serch position6">
    <input type="text" class="s1" name="id" placeholder="请输入教师号" id="id"/>


    <input type="submit" class="s1 s2" value="  "/>
</form>
<form action="/admin/changeTea" class="createClass position5" id="stuChange">
    <h1 id="or1">修改教师信息</h1>
    <div class="createClass-div">
        <p id="or2">姓名</p>
        <input type="text" name="name" class="s1" value="${user.name}"/>
    </div>

    <div class="createClass-div">
        <p id="or2">密码</p>
        <input type="text" name="password" class="s1" value="${user.password}"/>
    </div>

    <div class="createClass-div">
        <p id="or3">学科</p>
        <input type="text" name="subject" class="s1" value="${user.subject}"/>
    </div>

    <div class="createClass-div">
        <p id="or5">电话号</p>
        <input type="text" name="phone" class="s1" value="${user.phone}"/>
    </div>

    <div class="createClass-div">
        <p id="or6">备注</p>
        <input type="text" name="note" class="s1" value="${user.note}"/>
    </div>
    <div class="createClass-div">
        <p id="or7">工资</p>
        <input type="text" name="salary" class="s1" value="${user.salary}"/>
    </div>
    <div class="createClass-div">

        <input type="submit" value="完成修改" class="s1 s3" id="or7"/>
        <input type="hidden" value="${user.id}" name="id"/>
    </div>
    <!-- <input type="text" class="s1" name="c_id" placeholder="课号"/>
    <input type="text" name="c_name" class="s1" placeholder="课名"/>
    <input type="submit" class="s1 s2" value="  "/> -->
    <script type="text/javascript">
        if("${op}"=="1")
        {
            document.getElementById("id").value="${user.id}";
        }
    </script>
</form>
</body>
</html>
