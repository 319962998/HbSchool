<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/4/25
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="/stu.css"/>


    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resource/layui/css/layui.css">
    <link rel="stylesheet" href="/resource/layui/css/layui.mobile.css">
    <link rel="stylesheet" href="/ss.css">
    <script src="/resource\layui\layui.js"></script>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<cpn>
    <ul class="nav nav-tabs x1">
        <li class="active"><a href="/student/studentNotes">Home</a></li>

        <li><a href="/stu/studentInformation">账号信息</a></li>

        <li><a href="/stu/forumHome">论坛</a></li>
        <c:if test="${forumCount!=0}"><li><div class="hred" id="hred1"></div></c:if>
        <li id="x2"><a href="/stu/stuLogOut"><span class="glyphicon glyphicon-log-out">退出</span></a></li>
    </ul>
    <hr class="layui-bg-green">

    <ul class="x3">


        <a href="/student/studentNotes" id="deleteLine"><li id="act"><span class="glyphicon glyphicon-file"></span>&nbsp;&nbsp;&nbsp;笔记<c:if test="${noteCount != 0}"> <span class="badge" id="message">${noteCount}</span> </c:if>  </li></a>
        <a href="/stu/stuExam" id="deleteLine"><li><span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;&nbsp;考试<c:if test="${stuExamCount!=0}"><span class="badge" id="message">${stuExamCount}</span></c:if></li></a>
        <a href="/stu/stuViewCourse" id="deleteLine"><li><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;&nbsp;课程 <span class="layui-nav-more"></span></li></a>

    </ul>


</cpn>

<div id="stu-message">

    <form action="" class="serch" id="xpos1">
        <input type="text" class="s1" name="id" placeholder="请输入学号"/>


        <input type="submit" class="s1 s2" value="  "/>
    </form>

    <ul class="x4">
        <li><span class="label label-default">运达</span> <div>邢运达</div><span class="badge" id="message1">3</span><p>我爱你中国,你他太伟大哇啊挖坟挖坟挖</p></li>
        <li><span class="label label-default">凤英</span> <div>刘凤英</div><span class="badge" id="message1">3</span><p>你太。。</p></li>
        <li><span class="label label-default">小鸟</span></li>
    </ul>
</div>
<%--<script src="vue.js"></script>--%>
<%--<script src="resource/layui/layui.js"></script>--%>
<%--<script src="resource/layui/layui.all.js"></script>--%>
</body>
<script src="../../vue.js"></script>
<script src="../../resource/layui/layui.js"></script>
<script src="../../resource/layui/layui.all.js"></script>
</html>
