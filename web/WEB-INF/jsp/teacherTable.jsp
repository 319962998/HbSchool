<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/5/6
  Time: 4:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>教师表</title>
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
    <a href="/admin/teaTable" class="form1 act">教师表</a>
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
    <a href="/admin/createCourse" class="form1">创建课程</a>
</div>
<div class="left-finsh"></div>

<div class="home">
    <img src="../../img/home.png" >
    <div>我的桌面</div>
</div>
<form action="/admin/teaSerch" class="serch position3">
    <input type="text" id="stTableId" class="s1" name="id" placeholder="教师号"/>
    <input type="text" id="stTableName" class="s1" name="name" placeholder="姓名"/>

    <input type="submit" class="s1 s2" value="  "/>
</form>
<table class="opcourse-table position2">

    <tr>
        <td>教师号</td>
        <td>姓名</td>
        <td>密码</td>
        <td>科目</td>

        <td>电话号</td>
        <td>备注</td>
        <td>工资</td>
    </tr>
    <c:forEach items="${stuList}" var="s" varStatus="abc" >

        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.password}</td>
            <td>${s.subject}</td>

            <td>${s.phone}</td>
            <td>${s.note}</td>
            <td>${s.salary}</td>
        </tr>

    </c:forEach>


</table>
<div class="page position4">
    <a class="first-page" href="/admin/teaTablePage?currentP2=${currentP2}&totalP2=${totalP2}&op=1&tap=${tap}&name=${name}&id=${id}">
        <div class="first-page-trangle"></div>
        <div class="first-page-juxing">首页</div>
    </a>
    <a class="left-page" href="/admin/teaTablePage?currentP2=${currentP2}&totalP2=${totalP2}&op=2&tap=${tap}&name=${name}&id=${id}">
        <div></div>
        <div></div>
    </a>
    <div class="currentPage">- 第<span id="ctp">${currentP2}</span>页 -共${totalP2}页-</div>
    <a class="right_page" href="/admin/teaTablePage?currentP2=${currentP2}&totalP2=${totalP2}&op=3&tap=${tap}&name=${name}&id=${id}">
        <div></div>
        <div></div>
    </a>
    <a class="last-page" href="/admin/teaTablePage?currentP2=${currentP2}&totalP2=${totalP2}&op=4&tap=${tap}&name=${name}&id=${id}">
        <div class="last-page-juxing">尾页</div>
        <div class="last-page-trangle"></div>
    </a>
</div>

<script type="text/javascript">

    if("${tap}"=="2")
    {
        document.getElementById("stTableName").value="${name}"
    }
    if("${tap}"=="3")
    {
        document.getElementById("stTableId").value="${id}"
    }
</script>
</body>
</html>

