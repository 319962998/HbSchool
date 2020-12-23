<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/4/25
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/ss.css">
    <title>选择学生加入</title>
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
    <a href="/admin/goTeaUpdate" class="form1">教师修改</a>
</div>
<div class="mid-left">
    <img src="../../img/创建.png" >
    <a href="/admin/createCourse" class="form1 act">创建课程</a>
</div>
<div class="left-finsh"></div>

<div class="home">
    <img src="../../img/home.png" >
    <div>我的桌面</div>
</div>

<form action="/admin/insertRelition" class="selectStudent" id="selectStudent">
    <h3>请输入${number}个学生学号和姓名</h3>
    <br>
    <table class="selectStudent-table">

        <c:forEach var="i" begin="1" end="${number}">
            <tr>
                <td class="selectId">${i}</td>
                <td>学号</td><td><input type="text" class="s1" name="id${i}" placeholder="可不填写"></td>
                <td>姓名</td><td><input type="text" class="s1" name="name${i}"></td>
            </tr>
        </c:forEach>


    </table>
    <input type="hidden" name="number" value="${number}">

    <input type="hidden" name="name" value="${name}">

    <input type="submit" value="完成创建" class="s1 s4"/>
</form>

<form action="/admin/reName" class="selectStudent1" id="selectStudent1">
    <c:forEach var="nameStudent" items="${nameList}">
        <h3>输入的${nameStudent}的学生名字有重名，请输入其学号</h3>
    </c:forEach>
    <c:forEach var="j" begin="1" end="${nameListNumber}">
        <table class="selectStudent1-table">
            <tr>
                <td>
                    <input type="text" name="idOnly${j}"/>
                </td>
            </tr>
        </table>
    </c:forEach>
    <input type="submit" value="完成创建" class="s1 s4"/>
    <input type="hidden" name="name" value="${name}">
    <input type="hidden" name="nameListNumber" value="${nameListNumber}">
</form>
<script type="text/javascript">
    if("${tap}"=="")
    {
        document.getElementById("selectStudent").style.display="block";
        document.getElementById("selectStudent1").style.display="none";
    }
    if ("${tap}"=="1")
    {
        document.getElementById("selectStudent").style.display="none";
        document.getElementById("selectStudent1").style.display="block";
    }
</script>

</body>
</html>

