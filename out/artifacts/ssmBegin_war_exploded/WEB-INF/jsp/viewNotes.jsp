<%@ page import="com.colin.bean.Note" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/13
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType = "text/html;charset=UTF-8" language = "java" %>
<style>
    #rightInformation {
      float: left;
      position: relative;
      left: 200px;
      top: 50px;
      width: 220px;
    }

    #rightInformation>div {
      color: green;
      line-height: initial;
    }

    #note{
      float: left;
      margin: 0;
      height: 550px;
      width: 650px;
      position: relative;
      left: 40px;
      top: 30px;
    }

    #note>img {
      width: auto;
      max-height: 50%;
    }
</style>

<html>
<head>
    <meta charset="utf-8">
    <title>笔记</title>
    <script src="/resource/layui/layui.js"></script>
    <link rel="stylesheet" type="text/css" href="/stu.css"/>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/ss.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <link rel="stylesheet" href="/resource/layui/css/layui.css">
    <link rel="stylesheet" href="/resource/layui/css/modules/laydate/default/laydate.css">


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

<a href="/student/studentNotes" class="return position1">
    <div class="trangle"></div>
    <div class="juxing">返回</div>
</a>

<div id="stu-message1" >

    <div id="note" >
        <img src="/download/${fileName}" alt="临时图片"/>

        <textarea readonly="readonly" style="border:0;border-radius:5px;background-color:rgba(241,241,241,.98);width: 500px; height: 250px; resize: none; position: relative; top: 20px">
            ${note.textContent}
        </textarea>
    </div>


    <div id="rightInformation">

        <div> 标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题：<span id="title">${note.title}</span> </div>
        <div> 发&nbsp;布&nbsp;者：<span id="author">${note.teacher.name}</span> </div>
        <div> 课&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;程： <span id="course">${note.course.name}</span></div>
        <div> 发布时间： <span id="data">${note.date}</span> </div>
    </div>


</div>

<script src="/vue.js"></script>
<script src="/resource/layui/layui.js"></script>
<script src="/resource/layui/layui.all.js"></script>
</body>
</html>
