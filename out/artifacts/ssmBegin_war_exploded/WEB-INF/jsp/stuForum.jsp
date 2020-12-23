<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/6/9
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>论坛主页</title>
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
        <li><a href="/student/studentNotes">Home</a></li>

        <li><a href="/stu/studentInformation">账号信息</a></li>

        <li class="active"><a href="/stu/forumHome">论坛</a></li>
        <c:if test="${forumCount!=0}"><li><div class="hred" id="hred1"></div></c:if>

        <li id="x2"><a href="/stu/stuLogOut"><span class="glyphicon glyphicon-log-out">退出</span></a></li>
    </ul>
    <hr class="layui-bg-green">

    <ul class="x3">
        <a href="/stu/forumHome" id="deleteLine"><li><span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;&nbsp;论坛主页</li></a>
        <a href="/stu/postForum" id="deleteLine"><li><span class="glyphicon glyphicon-file"></span>&nbsp;&nbsp;&nbsp;发布论坛</li></a>
    </ul>
</cpn>

<div id="stu-message">
    <div class="hdiv">
        <span>红博文化学校论坛</span>
    </div>
    <ul class="hx4">
        <div style="height: 500px;">
            <c:forEach var="forum" items="${forumList.list}">
            <li><a href="/stu/viewContent?id=${forum.id}">
                <span class="label label-default">${forum.user.name}</span><span class="label label-default">${forum.teacher.name}</span>
                <div>${forum.user.name}</div><div>${forum.teacher.name}</div>
                <p>${forum.title}</p>
            </a></li>
            <div class="htime">发布时间：${forum.updateTime}</div>
            </c:forEach>
        </div>
        <div class="hfenye">
            <a href="/stu/selectForumByPage?currentPage=1">首页</a>
            <a href="/stu/selectForumByPage?currentPage=${forumList.currentPage-1}">上一页</a>
            <span>当前${forumList.currentPage}页</span>
            <a href="/stu/selectForumByPage?currentPage=${forumList.currentPage+1}">下一页</a>
            <a href="/stu/selectForumByPage?currentPage=${forumList.totalPage}">末页</a>
        </div>
    </ul>

</div>
<script src="/vue.js"></script>
<script src="/resource/layui/layui.js"></script>
<script src="/resource/layui/layui.all.js"></script>
</body>
</html>
