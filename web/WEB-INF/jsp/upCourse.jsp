<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/5/3
  Time: 3:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/ss.css">
    <title>修改课程</title>
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
    <a href="/admin/upCourse" class="form1 act">课程修改</a>
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

<form class="upCourse" action="/admin/doUpCourse">
    <input type="text" class="s1" placeholder="请输入课号" name="c_id" id="upCourseId">
    <input type="submit" value="  " class="s1 s2"/>
    <input type="hidden" value="1" class="s1 s2"/>
</form>
<table class="chooseStudent-table upCourse-table">
    <tr>
        <td id="upCourse-table-main">课名</td>
        <td>${upList.get(0).name}</td>
        <td id="upCourse-table-main">教师费</td>
        <td>${upList.get(0).tPay}</td>
        <td id="upCourse-table-main">学费</td>
        <td>${upList.get(0).sPay}</td>
        <td id="upCourse-table-main">上课教师</td>
        <td>${upList.get(0).tName}</td>
        <td id="upCourse-table-main">上课时间</td>
        <td>${upList.get(0).time}</td>
    </tr>
</table>
<div class="studentList">

    <h3 style="text-align: center; color: #129d90;">该班学生：</h3>
    <c:forEach items="${c_sList}" var="s" varStatus="abc" >
        <div class="studentLable">${s.sName}</div>

    </c:forEach>

</div>
<form action="/admin/doUpCourse" class="chooseStudent left-width b1" id="opCourseTap1">
    <h3>搜索需<span class="insertColor">添加</span>的学生</h3><br>
    <input type="text" class="s1" name="s_id1" placeholder="学号" id="s_id1"/>
    <input type="text" name="s_name1" class="s1" placeholder="姓名" id="s_name1"/>
    <input type="submit" class="s1 s2" value="  "/>
    <input type="hidden" name="tap" value="1"/>
    <input type="hidden" name="c_id" value="${upList.get(0).id}"/>
</form>
<table class="chooseStudent-table left-width " id="opCourseTap2">
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>学校</td>
        <td>手机号</td>
        <td>学费</td>

        <td>操作</td>
    </tr>
    <c:forEach items="${serchList1}" var="s" varStatus="abc" >

        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.school}</td>
            <td>${s.phone}</td>
            <td>${s.tuition}</td>

            <td><a id="okInsert" href="/admin/upCourseMain?tap=1&id=${s.id}&upCourse_id=${upList.get(0).id}">确认添加</a></td>
        </tr>
    </c:forEach>

</table>
<form action="/admin/doUpCourse" class="chooseStudent left-width b2" id="opCourseTap3">
    <h3>搜索需<span class="deleteColor">删除</span>的学生</h3><br>
    <input type="text" class="s1" name="s_id2" placeholder="学号" id="s_id2"/>
    <input type="text" name="s_name2" class="s1" placeholder="姓名" id="s_name2"/>
    <input type="submit" class="s1 s2" value="  "/>
    <input type="hidden" name="tap" value="2"/>
    <input type="hidden" name="c_id" value="${upList.get(0).id}"/>
</form>
<table class="chooseStudent-table left-width" id="opCourseTap4">
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>学校</td>
        <td>手机号</td>
        <td>学费</td>

        <td>操作</td>
    </tr>
    <c:forEach items="${serchList2}" var="s" varStatus="abc" >

        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.school}</td>
            <td>${s.phone}</td>
            <td>${s.tuition}</td>

            <td><a id="okdelete" href="/admin/upCourseMain?tap=2&id=${s.id}&upCourse_id=${upList.get(0).id}">确认删除</a></td>
        </tr>
    </c:forEach>
</table>

<div class="increaseStudent" onclick="insert()" id="taq1">
    <div class="increaseStudent-juxing">添加学生</div>
    <div class="increaseStudent-trangle"></div>
</div>
<div class="deleteStudent" onclick="deleted()" id="taq2">
    <div class="deleteStudent-juxing">删除学生</div>
    <div class="deleteStudent-trangle"></div>
</div>
<div class="upCourseMain" onclick="upCourse()" id="taq3">
    <div class="upCourseMain-juxing">修改课程</div>
    <div class="upCourseMain-trangle"></div>
</div>


<form action="/admin/upCourseMain" class="createClass upCoursePosition" id="opCourseTap5">
    <h1 id="or1">修改课程</h1>
    <div class="createClass-div">
        <p id="or2">课名</p>
        <input type="text" name="upCourseName" class="s1" value="" id="upCourseName"/>
    </div>

    <div class="createClass-div">
        <p id="or3">教师</p>
        <input type="text" name="upCourseT_name" class="s1" value="" id="upCourseT_name"/>
    </div>
    <div class="createClass-div">
        <p id="or4">学生费</p>
        <input type="text" name="upCourseS_pay" class="s1" value="" id="upCourseS_pay"/>
    </div>
    <div class="createClass-div">
        <p id="or5">教师费</p>
        <input type="text" name="upCourseT_pay" class="s1" value="" id="upCourseT_pay"/>
    </div>

    <div class="createClass-div">
        <p id="or6">上课时间</p>
        <input type="text" name="upCourseTime" class="s1" value="" id="upCourseTime"/>
    </div>
    <div class="createClass-div">

        <input type="submit" value="完成修改" class="s1 s3" id="or7"/>
    </div>
    <input type="hidden" value="3" name="tap"/>
    <input type="hidden" value="${upList.get(0).id}" name="upCourse_id"/>
    <!-- <input type="text" class="s1" name="c_id" placeholder="课号"/>
    <input type="text" name="c_name" class="s1" placeholder="课名"/>
    <input type="submit" class="s1 s2" value="  "/> -->
</form>

<script type="text/javascript">
    if("${upCourse}"=="")
    {
        document.getElementById("opCourseTap1").style.display="none";
        document.getElementById("opCourseTap2").style.display="none";
        document.getElementById("opCourseTap3").style.display="none";
        document.getElementById("opCourseTap4").style.display="none";
        document.getElementById("opCourseTap5").style.display="none";
        document.getElementById("taq1").style.display="none";
        document.getElementById("taq2").style.display="none";
        document.getElementById("taq3").style.display="none";
    }
    if("${upCourse}"=="1")
    {
        document.getElementById("opCourseTap1").style.display="none";
        document.getElementById("opCourseTap2").style.display="none";
        document.getElementById("opCourseTap3").style.display="none";
        document.getElementById("opCourseTap4").style.display="none";
        document.getElementById("opCourseTap5").style.display="none";
        document.getElementById("upCourseId").value="${upList.get(0).id}";
    }
    if("${upCourse}"=="2")
    {
        document.getElementById("opCourseTap3").style.display="none";
        document.getElementById("opCourseTap4").style.display="none";
        document.getElementById("opCourseTap5").style.display="none";
        document.getElementById("upCourseId").value="${upList.get(0).id}";
        document.getElementById("s_id1").value="${s_id1}";
        document.getElementById("s_name1").value="${s_name1}";
    }
    if("${upCourse}"=="3")
    {
        document.getElementById("opCourseTap1").style.display="none";
        document.getElementById("opCourseTap2").style.display="none";
        document.getElementById("opCourseTap5").style.display="none";
        document.getElementById("upCourseId").value="${upList.get(0).id}";
        document.getElementById("s_id2").value="${s_id2}";
        document.getElementById("s_name2").value="${s_name2}";
    }
    if("${upCourse}"=="4")
    {
        document.getElementById("opCourseTap3").style.display="none";
        document.getElementById("opCourseTap4").style.display="none";
        document.getElementById("opCourseTap1").style.display="none";
        document.getElementById("opCourseTap2").style.display="none";
        document.getElementById("upCourseId").value="${upList.get(0).id}";
    }

    function insert()
    {
        document.getElementById("opCourseTap5").style.display="none";
        document.getElementById("opCourseTap3").style.display="none";
        document.getElementById("opCourseTap4").style.display="none";
        document.getElementById("opCourseTap1").style.display="block";
        document.getElementById("opCourseTap2").style.display="block";

    }
    function deleted()
    {
        document.getElementById("opCourseTap5").style.display="none";
        document.getElementById("opCourseTap1").style.display="none";
        document.getElementById("opCourseTap2").style.display="none";
        document.getElementById("opCourseTap3").style.display="block";
        document.getElementById("opCourseTap4").style.display="block";
    }
    function upCourse()
    {
        document.getElementById("opCourseTap5").style.display="block";
        document.getElementById("opCourseTap1").style.display="none";
        document.getElementById("opCourseTap2").style.display="none";
        document.getElementById("opCourseTap3").style.display="none";
        document.getElementById("opCourseTap4").style.display="none";
        document.getElementById("upCourseName").value="${upList.get(0).name}";
        document.getElementById("upCourseT_name").value="${upList.get(0).tName}";
        document.getElementById("upCourseS_pay").value="${upList.get(0).sPay}";
        document.getElementById("upCourseT_pay").value="${upList.get(0).tPay}";
        document.getElementById("upCourseTime").value="${upList.get(0).time}";
    }
</script>
</body>
</html>

