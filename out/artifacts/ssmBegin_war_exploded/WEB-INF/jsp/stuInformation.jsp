<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/6/13
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>账户信息</title>
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

        <li class="active"><a href="/stu/studentInformation">账号信息</a></li>

        <li><a href="/stu/forumHome">论坛</a></li>
        <c:if test="${forumCount!=0}"><li><div class="hred" id="hred1"></div></c:if>
        <li id="x2"><a href="/stu/stuLogOut"><span class="glyphicon glyphicon-log-out">退出</span></a></li>
    </ul>
    <hr class="layui-bg-green">



</cpn>


<div id="stu-message">
    <div class="hdivtable1">账户信息</div>
    <table class="htable" border="1">
        <tr>
            <td class="htd1">学生号</td>
            <td class="htd2">${stuInformation.id}</td>
        </tr>
        <tr>
            <td class="htd1">用户名</td>
            <td class="htd2">${stuInformation.name}</td>
        </tr>
        <tr>
            <td class="htd1">密码</td>
            <td class="htd2">${stuInformation.password}</td>
        </tr>
        <tr>
            <td class="htd1">年级</td>
            <td class="htd2">${stuInformation.grade}</td>
        </tr>
        <tr>
            <td class="htd1">学校</td>
            <td class="htd2">${stuInformation.school}</td>
        </tr>
        <tr>
            <td class="htd1">手机号</td>
            <td class="htd2">${stuInformation.phone}</td>
        </tr>
        <tr>
            <td class="htd1">备注</td>
            <td class="htd2">${stuInformation.note}</td>
        </tr>
        <tr>
            <td class="htd1">学费</td>
            <td class="htd2">${stuInformation.tuition}</td>
        </tr>
    </table>
    <div class="hdivtable2">
        可修改信息
    </div>
    <form action="/stu/updateInformation" class="hform">
        <label for="password">密码：&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="password" id="password"/><br>
        <label for="phone">手机号：</label><input type="text" name="phone" id="phone"/><br>
        <label for="note">备注：&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="note" id="note"/><br>
        <br><br><br>
        <input type="submit" value="提交" class="hformsubmit">
    </form>
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
