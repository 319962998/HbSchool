<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/5/4
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>查看历史及上课学生</title>
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
    <a href="/admin/opCourse" class="form1 act">课程管理</a>
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
    <a href="/admin/createCourse" class="form1">创建课程</a>
</div>
<div class="left-finsh"></div>

<a href="/admin/opCourse" class="return position1">
    <div class="trangle"></div>
    <div class="juxing">返回</div>
</a>

<div class="studentList">
    <h2 class="cs1">当堂课上课学生</h2>
    <c:forEach items="${SrelitionList}" var="s" varStatus="abc" >

        <div class="studentLable">${s.sName}</div>

    </c:forEach>


</div>
<div class="historyLook" id="oplook1">
    <table class="opcourse-table cs2">
        <tr>
            <td>序号</td>
            <td>教师费</td>
            <td>学费</td>
            <td>历史记录</td>
            <td>查看</td>
        </tr>
        <c:forEach items="${historyList}" var="s" varStatus="abc" >

            <tr>
                <td class="s1">${(currentP1-1)*5+abc.index+1}</td>
                <td class="s1">${s.tPay}</td>
                <td class="s1">${s.sPay}</td>
                <td class="s1">${s.history}</td>
                <td><a id="cs3" href="/admin/lookHistory?courseid=${courseid}&currentP1=${currentP1}&lookHistory=${s.history}">点击查看</a></td>
            </tr>

        </c:forEach>


    </table>
</div>
<div class="page cs4" id="oplook2">
    <a class="first-page" href="/admin/lookHistory?optap=1&currentP1=${currentP1}&courseid=${courseid}">
        <div class="first-page-trangle"></div>
        <div class="first-page-juxing">首页</div>
    </a>
    <a class="left-page" type="button" href="/admin/lookHistory?optap=2&currentP1=${currentP1}&courseid=${courseid}">
        <div></div>
        <div></div>
    </a>
    <div class="currentPage">- 第<span id="ctp">${currentP1}</span>页 -共${totalP1}页-</div>
    <a type="button" class="right_page" href="/admin/lookHistory?optap=3&currentP1=${currentP1}&courseid=${courseid}">
        <div></div>
        <div></div>
    </a>
    <a class="last-page" href="/admin/lookHistory?optap=4&currentP1=${currentP1}&courseid=${courseid}">
        <div class="last-page-juxing">尾页</div>
        <div class="last-page-trangle"></div>
    </a>
</div>


<div class="historyLook" id="oplook3">
    <table class="opcourse-table cs2">
        <tr>
            <td>序号</td>
            <td>教师费</td>
            <td>学费</td>
            <td>历史记录</td>
            <td>查看</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${historyList}" var="s" varStatus="abc" >

            <tr>
                <td class="s1">${(currentP1-1)*5+abc.index+1}</td>
                <td class="s1">${s.tPay}</td>
                <td class="s1">${s.sPay}</td>
                <td class="s1">${s.history}</td>
                <td><a id="cs3" href="/admin/lookHistory?courseid=${courseid}&currentP1=${currentP1}&lookHistory=${s.history}&oplook=2">点击查看</a></td>
                <td><a id="cs5" href="/admin/lookHistory?courseid=${courseid}&currentP1=${currentP1}&lookHistory=${s.history}&deleteop=1">点击删除</a></td>
            </tr>

        </c:forEach>


    </table>
</div>
<div class="page cs4" id="oplook4">
    <a class="first-page" href="/admin/lookHistory?optap=1&currentP1=${currentP1}&courseid=${courseid}&oplook=2">
        <div class="first-page-trangle"></div>
        <div class="first-page-juxing">首页</div>
    </a>
    <a class="left-page" type="button" href="/admin/lookHistory?optap=2&currentP1=${currentP1}&courseid=${courseid}&oplook=2">
        <div></div>
        <div></div>
    </a>
    <div class="currentPage">- 第<span id="ctp">${currentP1}</span>页 -共${totalP1}页-</div>
    <a type="button" class="right_page" href="/admin/lookHistory?optap=3&currentP1=${currentP1}&courseid=${courseid}&oplook=2">
        <div></div>
        <div></div>
    </a>
    <a class="last-page" href="/admin/lookHistory?optap=4&currentP1=${currentP1}&courseid=${courseid}&oplook=2">
        <div class="last-page-juxing">尾页</div>
        <div class="last-page-trangle"></div>
    </a>
</div>
<script type="text/javascript">
if("${oplook}"=="1")
{
    document.getElementById("oplook1").style.display="block";
    document.getElementById("oplook2").style.display="block";
    document.getElementById("oplook3").style.display="none";
    document.getElementById("oplook4").style.display="none";
}
if("${oplook}"=="2")
{
    document.getElementById("oplook1").style.display="none";
    document.getElementById("oplook2").style.display="none";
    document.getElementById("oplook3").style.display="block";
    document.getElementById("oplook4").style.display="block";
}
</script>
</body>
</html>

