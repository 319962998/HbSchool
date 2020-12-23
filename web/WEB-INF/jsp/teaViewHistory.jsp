<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/18
  Time: 1:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>查看历史</title>



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
        <a href="/tea/lookStuExam" id="deleteLine"><li><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;&nbsp;学生答卷<c:if test="${teaExamCount!=0}"><span class="badge" id="message">${teaExamCount}</span></c:if></li></a>
        <a href="/tea/exam" id="deleteLine"><li><span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;&nbsp;考试管理</li></a>
        <a href="/tea/teaViewCourse" id="deleteLine"><li id="act"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;&nbsp;课程</li></a>

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
<a href="javascript:history.go(-1);" class="return position1">
    <div class="trangle"></div>
    <div class="juxing">返回</div>
</a>
<div class="allBorder">
    <div class="orangeRow">上课历史记录</div>
    <div class="orangeCol"></div>
</div>

<table class="opcourse-table position2">

    <tr>
        <td>课程号</td>
        <td>课时费</td>
        <td>历史记录</td>



    </tr>
    <c:forEach items="${list}" var="s">
        <tr>
            <td>${s.cId}</td>
            <td>${s.tPay}</td>
            <td>${s.history}</td>




        </tr>

    </c:forEach>

</table>


<div class="page position4">
    <a class="first-page" href="/tea/teaViewHistoryPage?currentPage=${currentPage}&totalPage=${totalPage}&op=1">
        <div class="first-page-trangle"></div>
        <div class="first-page-juxing">首页</div>
    </a>
    <a class="left-page" type="button" href="/tea/teaViewHistoryPage?currentPage=${currentPage}&totalPage=${totalPage}&op=2">
        <div></div>
        <div></div>
    </a>
    <div class="currentPage">- 第<span id="ctp">${currentPage}</span>页 -共${totalPage}页-</div>
    <a type="button" class="right_page" href="/tea/teaViewHistoryPage?currentPage=${currentPage}&totalPage=${totalPage}&op=3">
        <div></div>
        <div></div>
    </a>
    <a class="last-page" href="/tea/teaViewHistoryPage?currentPage=${currentPage}&totalPage=${totalPage}&op=4">
        <div class="last-page-juxing">尾页</div>
        <div class="last-page-trangle"></div>
    </a>

</div>


</body>
</html>

