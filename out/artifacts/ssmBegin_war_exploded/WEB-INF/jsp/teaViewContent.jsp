<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/6/9
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>查看内容</title>
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
        <li><a href="/teacher/teacherNotes">Home</a></li>

        <li><a href="/tea/teacherInformation">账号信息</a></li>

        <li class="active"><a href="/tea/forumHome">论坛</a></li>

        <li id="x2"><a href="/tea/teaLogOut"><span class="glyphicon glyphicon-log-out">退出</span></a></li>
    </ul>
    <hr class="layui-bg-green">

    <ul class="x3">
        <a href="/tea/forumHome" id="deleteLine"><li><span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;&nbsp;论坛主页</li></a>
        <a href="/tea/postForum" id="deleteLine"><li><span class="glyphicon glyphicon-file"></span>&nbsp;&nbsp;&nbsp;发布论坛</li></a>

    </ul>
</cpn>

<div id="stu-message">
    <span id="htouxiang1" class="label label-default">${forumContent.user.name}</span>
    <span id="htouxiang2" class="label label-default">${forumContent.teacher.name}</span>
    <div style="height: 44px;line-height: 44px;font-size: 20px;float: left;">&nbsp;${forumContent.user.name}</div>
    <div style="height: 44px;line-height: 44px;font-size: 20px;float: left;">&nbsp;${forumContent.user.name}</div>
    <br>
    <br>
    <div style="padding-top: 22px;">
        <span class="hspan">标题：</span>
        <span style="float:left;font-size: 20px;">${forumContent.title}</span>
    </div>
    <div style="padding-top: 40px;">
        <span class="hspan">内容：</span>
        <span style="float:left;font-size: 20px;">${forumContent.problem}</span>
    </div>
    <br>
    <br>
    <img class="himg" src="/download/${forumContent.imgName}" />
    <div style="padding-left:50px; padding-top: 20px;">
        <div class="htime">发布时间：${forumContent.updateTime}</div>
        <table class="hselect">
            <c:forEach var="reply" items="${replyList}">
                <tr>
                    <td><span style="color: blue;">${reply.user.name}</span>
                        <span style="color: blue;">${reply.teacher.name}</span><span>：${reply.message}</span></td>
                </tr>
            </c:forEach>
        </table>
        <form action="/tea/insertReplyViewContent" method="post">
            <input class="hinput1" type="text" name="message" placeholder="请输入回复留言">
            <input type="hidden" value="${forumContent.id}" name="fId"/>
            <input style="background-color: rgb(151, 218, 52);height: 30px;width: 50px;color: white;" type="submit" value="提交">
        </form>
    </div>
</div>
<script src="/vue.js"></script>
<script src="/resource/layui/layui.js"></script>
<script src="/resource/layui/layui.all.js"></script>
<script>
    if("${tap}"=="1")
    {
        document.getElementById("hred1").style.display="none";
        document.getElementById("hred2").style.display="none";
    }
    if ("${tap}"=="2")
    {
        document.getElementById("hred1").style.display="block";
        document.getElementById("hred2").style.display="block";
    }
</script>
</body>
</html>
