<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/17
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>查看学生考试</title>



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
        <li class="active"><a href="/teacher/teacherNotes">Home</a></li>

        <li><a href="/tea/teacherInformation">账号信息</a></li>

        <li><a href="/tea/forumHome">论坛</a></li>
        <c:if test="${forumCount!=0}"><li><div class="hred" id="hred1"></div></c:if>

        <li id="x2"><a href="/tea/teaLogOut"><span class="glyphicon glyphicon-log-out">退出</span></a></li>
    </ul>
    <hr class="layui-bg-green">

    <ul class="x3">
        <a href="/teacher/teacherNotes" id="deleteLine"><li><span class="glyphicon glyphicon-file"></span>&nbsp;&nbsp;&nbsp;笔记</li></a>
        <a href="/tea/opProblem" id="deleteLine"><li><span class="glyphicon glyphicon-bell"></span>&nbsp;&nbsp;&nbsp;题库管理</li></a>
        <a href="/tea/createProblem" id="deleteLine"><li><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;&nbsp;创建试题</li></a>
        <a href="/tea/lookStuExam" id="deleteLine"><li id="act"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;&nbsp;学生答卷<c:if test="${teaExamCount!=0}"><span class="badge" id="message">${teaExamCount}</span></c:if></li></a>
        <a href="/tea/exam" id="deleteLine"><li><span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;&nbsp;考试管理</li></a>
        <a href="/tea/teaViewCourse" id="deleteLine"><li><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;&nbsp;课程</li></a>

    </ul>


</cpn>

<!--<div id="stu-message">-->

<!--    <form action="" class="serch xpos1" id="xpos1">-->
<!--        <input type="text" class="s1" name="id" placeholder="请输入学号"/>-->


<!--        <input type="submit" class="s1 s2" value="  "/>-->
<!--    </form>-->

<!--  <ul class="x4">-->
<!--      <li><span class="label label-default">运达</span> <div>邢运达</div><span class="badge" id="message1">3</span><p>我爱你中国,你他太伟大哇啊挖坟挖坟挖</p></li>-->
<!--      <li><span class="label label-default">凤英</span> <div>刘凤英</div><span class="badge" id="message1">3</span><p>你太。。</p></li>-->
<!--      <li><span class="label label-default">小鸟</span></li>-->
<!--  </ul>-->
<!--</div>-->
<div class="allBorder">
    <div class="orangeRow">学生提交</div>
    <div class="orangeCol"></div>
</div>
<form action="/tea/searchViewExam" id="xpos7">
    <input type="text" placeholder="考试号" class="s1" name="eId1" id="eId1">
    <input type="text" placeholder="学生姓名" class="s1" name="sName" id="sName">
    <input type="text" placeholder="课程号" class="s1" name="cId" id="cId">
    <input type="submit" class="s1 s2" value=" ">
</form>
<table class="opcourse-table" id="xpos13">

    <tr>
        <td>考试号</td>
        <td>课名</td>
        <td>考试名字</td>
        <td>学生姓名</td>
        <td>提交时间</td>
        <td>截止时间</td>
        <td>打分</td>
        <td colspan="2">操作</td>

    </tr>
    <c:forEach items="${list}" var="s">
        <tr>
            <td>${s.eId}</td>
            <td>${s.cName}</td>
            <td>${s.eName}</td>
            <td>${s.sName}</td>
            <td>${s.time}</td>
            <td>${s.last}</td>
            <td>${s.submit}</td>
            <td><a href="/tea/goStuExam?eId=${s.eId}&sName=${s.sName}" id="okExam">查看考试</a></td>
            <td><a href="/tea/updateScore?eId=${s.eId}&sName=${s.sName}" id="lookExam">打分</a></td>
        </tr>
    </c:forEach>


</table>


<div class="page position4">
    <a class="first-page" href="/tea/viewExamPage?currentPage=${currentPage}&totalPage=${totalPage}&op=1&tap=${tap}&eId1=${eId1}&sName=${sName}&cId=${cId}">
        <div class="first-page-trangle"></div>
        <div class="first-page-juxing">首页</div>
    </a>
    <a class="left-page" type="button" href="/tea/viewExamPage?currentPage=${currentPage}&totalPage=${totalPage}&op=2&tap=${tap}&eId1=${eId1}&sName=${sName}&cId=${cId}">
        <div></div>
        <div></div>
    </a>
    <div class="currentPage">- 第<span id="ctp">${currentPage}</span>页 -共${totalPage}页-</div>
    <a type="button" class="right_page" href="/tea/viewExamPage?currentPage=${currentPage}&totalPage=${totalPage}&op=3&tap=${tap}&eId1=${eId1}&sName=${sName}&cId=${cId}">
        <div></div>
        <div></div>
    </a>
    <a class="last-page" href="/tea/viewExamPage?currentPage=${currentPage}&totalPage=${totalPage}&op=4&tap=${tap}&eId1=${eId1}&sName=${sName}&cId=${cId}">
        <div class="last-page-juxing">尾页</div>
        <div class="last-page-trangle"></div>
    </a>
</div>
<script type="text/javascript">
    document.getElementById("eId1").value="${eId1}";
    document.getElementById("sName").value="${sName}";
    document.getElementById("cId").value="${cId}";
</script>

</body>
</html>

