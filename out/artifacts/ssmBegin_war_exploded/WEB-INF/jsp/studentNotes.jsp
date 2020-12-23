<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/13
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType = "text/html;charset=UTF-8" language = "java" %>
<style>
    /* 表格及内部元素样式 */
    table, td {
      border-style: solid;
      border-color: rgba(0, 0, 0, 0.164);
      border-width: 1px;
      border-collapse: collapse;
      text-align: center;
    }

    td {
      width: 160px;
      height: 30px;
    }
    thead {
      background-color: rgba(0, 0, 0, 0.068);
    }

    .redPoint {
        position:relative;


    }
    .tip {
        display:block;
        background: #d80000;
        border-radius:50%;
        width:8px;
        height:8px;
        top:0px;
        right:0px;
        position:absolute;
    }

</style>

<html>
<head>
    <meta charset="utf-8">
    <title>学生笔记</title>
    <link rel="stylesheet" type="text/css" href="/stu.css"/>
    <link rel="stylesheet" type="text/css" href="/ss.css">


    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resource/layui/css/layui.css">
    <link rel="stylesheet" href="/resource/layui/css/layui.mobile.css">

    <script src="/resource/layui/layui.js"></script>
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
<div>

</div>

<div id="stu-message" >
    <form action="#">

        <table id="noteList" lay-filter="noteList" style="position: relative; top: 20PX; ">
            <thead>
            <tr>
                <td>ID</td>
                <td>笔记标题</td>
                <td>发布者</td>
                <td>发布时间</td>
                <td>对应课程</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${notesMap.keySet()}" var="note">
            <tr>
                <td>${note.id}</td>
                <td>${note.title}</td>
                <td>${note.teacher.name}</td>
                <td>${note.date}</td>
                <td>${note.course.name}</td>
                <td>
                    <a class="layui-btn layui-btn-xs layui-btn-primary" lay-event="look" href="/student/viewNotes?id=${note.id}">查看</a>
                    <c:if test="${!notesMap.get(note)}">  <%--判断是否已经查看--%>
                        <span class="redPoint">
                             <i class="tip"> </i>
                        </span>
                    </c:if>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>

    <div class="page" id="notePage">
        <a class="first-page" href="/student/studentNotes?currentPage=1">
            <div class="first-page-trangle"></div>
            <div class="first-page-juxing">首页</div>
        </a>
        <a class="left-page" href="/student/studentNotes?currentPage=${currentPage - 1}">
            <div></div>
            <div></div>
        </a>
        <div class="currentPage">- 第<span id="ctp">${currentPage}</span>页 -共${totalPage}页-</div>
        <a class="right_page" href="/student/studentNotes?currentPage=${currentPage + 1}">
            <div></div>
            <div></div>
        </a>
        <a class="last-page" href="/student/studentNotes?currentPage=${totalPage}">
            <div class="last-page-juxing">尾页</div>
            <div class="last-page-trangle"></div>
        </a>
    </div>


</div>

<script src="/vue.js"></script>
<script src="/resource/layui/layui.js"></script>
<script src="/resource/layui/layui.all.js"></script>
</body>
</html>
