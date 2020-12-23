<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/6/13
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>教师工资</title>
    <link rel="stylesheet" type="text/css" href="/stu.css"/>

    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resource/layui/css/layui.css">
    <link rel="stylesheet" href="/resource/layui/css/layui.mobile.css">
    <link rel="stylesheet" href="cssFile.css">
    <script src="/resource/layui/layui.js"></script>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<cpn>
    <ul class="nav nav-tabs x1">
        <li><a href="#">Home</a></li>

        <li><a href="/tea/teacherInformation">账号信息</a></li>
        <li class="active"><a href="/tea/teacherSalary">查看学费</a></li>
        <li><a href="/tea/forumHome">论坛</a></li>
        <li><div class="hred" id="hred1"></div></li>
        <li id="x2"><a href="#"><span class="glyphicon glyphicon-log-out">退出</span></a></li>
    </ul>
    <hr class="layui-bg-green">

    <ul class="x3">
        <li><span class="glyphicon glyphicon-file"></span><a href="">&nbsp;&nbsp;&nbsp;笔记</a></li>
        <li><span class="glyphicon glyphicon-pencil"></span><a href="">&nbsp;&nbsp;&nbsp;考试</a></li>
        <li><span class="glyphicon glyphicon-list-alt"></span><a href="">&nbsp;&nbsp;&nbsp;课程 </a></li>
    </ul>
</cpn>

<div id="stu-message">
    <div class="hsay">工资：${teacher.salary}</div>
</div>
<script src="/vue.js"></script>
<script src="/resource/layui/layui.js"></script>
<script src="/resource/layui/layui.all.js"></script>
<script>
    if("${tap}"=="1")
    {
        document.getElementById("hred1").style.display="none";
    }
    if ("${tap}"=="2")
    {
        document.getElementById("hred1").style.display="block";
    }
</script>
</body>
</html>
