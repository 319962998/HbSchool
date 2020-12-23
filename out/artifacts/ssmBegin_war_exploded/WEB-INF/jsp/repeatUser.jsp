<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/4
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/ss.css" >

    <title>重复学生</title>
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
    <a href="LoginServlet?name=xz&password=555" class="form1 act">课程管理</a>
</div>
<div class="mid-left">
    <img src="../../img/学生.png" >
    <a href="StudentTableServlet" class="form1">学生表</a>
</div>
<div class="mid-left">
    <img src="../../img/教师.png" >
    <a href="TeacherTableServlet" class="form1">教师表</a>
</div>
<div class="mid-left">
    <img src="../../img/管理.png" >
    <a href="upCourse.jsp" class="form1">课程修改</a>
</div>
<div class="mid-left">
    <img src="../../img/创建.png" >
    <a href="upStudent.jsp" class="form1">学生修改</a>
</div>
<div class="mid-left">
    <img src="../../img/管理.png" >
    <a href="upTeacher.jsp" class="form1">教师修改</a>
</div>
<div class="mid-left">
    <img src="../../img/创建.png" >
    <a href="createCourse.jsp" class="form1">创建课程</a>
</div>
<div class="left-finsh"></div>
<div class="home">
    <img src="../../img/home.png" >
    <div>我的桌面</div>
</div>
<a href="javascript:history.go(-1);" class="return">
    <div class="trangle"></div>
    <div class="juxing">返回</div>
</a>
<form action="/admin/repeatLeave" class="selectStudent">
    <h3>以下学生姓名有重复，请输入学号</h3>
    <br>
    <table class="selectStudent-table">
    <c:forEach items="${listUser}" var="s" varStatus="x">
        <tr>
            <td class="selectId">${x.index}</td>
            <td>学号</td><td><input type="text" class="s1" id="id${x.index}"></td>
            <td>姓名</td><td><input type="text" class="s1" value="${s.name}"></td>
        </tr>

    </c:forEach>

    </table>
    <input type="submit" value="完成添加" class="s1 s4"/>
    <input type="hidden" value="${relitions}" name="relitions" class="s1 s4"/>
    <input type="hidden" value="${listUser.size()}" name="size">
    <input type="hidden" value="${history}" name="history">
    <!-- <input type="text" class="s1" name="c_id" placeholder="课号"/>
    <input type="text" name="c_name" class="s1" placeholder="课名"/>
    <input type="submit" class="s1 s2" value="  "/> -->
</form>
</body>
</html>
