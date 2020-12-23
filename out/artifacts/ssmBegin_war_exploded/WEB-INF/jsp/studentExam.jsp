<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/13
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>学生考试</title>



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
        <li class="active"><a href="/student/studentNotes">Home</a></li>

        <li><a href="/stu/studentInformation">账号信息</a></li>

        <li><a href="/stu/forumHome">论坛</a></li>
        <c:if test="${forumCount!=0}"><li><div class="hred" id="hred1"></div></c:if>
        <li id="x2"><a href="/stu/stuLogOut"><span class="glyphicon glyphicon-log-out">退出</span></a></li>
    </ul>
    <hr class="layui-bg-green">

    <ul class="x3">


        <a href="/student/studentNotes" id="deleteLine"><li><span class="glyphicon glyphicon-file"></span>&nbsp;&nbsp;&nbsp;笔记<c:if test="${noteCount != 0}"> <span class="badge" id="message">${noteCount}</span> </c:if>  </li></a>
        <a href="/stu/stuExam" id="deleteLine"><li id="act"><span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;&nbsp;考试<c:if test="${stuExamCount!=0}"><span class="badge" id="message">${stuExamCount}</span></c:if></li></a>
        <a href="/stu/stuViewCourse" id="deleteLine"><li><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;&nbsp;课程 <span class="layui-nav-more"></span></li></a>

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
    <div class="orangeRow">考试管理</div>
    <div class="orangeCol"></div>
</div>

<table class="opcourse-table" id="xpos13">

    <tr>
        <td>考试号</td>
        <td>课名</td>
        <td>考试名字</td>
        <td>所在章节</td>
        <td>发布时间</td>
        <td>截止时间</td>
        <td>分数</td>
        <td colspan="2">操作</td>

    </tr>

    <c:forEach items="${list}" var="s" varStatus="x">
        <tr>
            <td>${s.eId}</td>
            <td>${s.cName}</td>
            <td>${s.eName}</td>
            <td>${s.section}</td>
            <td>${s.begin}</td>
            <td>${s.last}</td>
            <td>${s.submit}</td>
            <td><a href="/stu/doStuExam?eId=${s.eId}" id="okExam" onclick="return getFormatDate()<='${s.last}'?true:(alert('考试时间已过，禁止答题'),false)">进入考试</a></td>
            <td><a href="/stu/doStuExam?eId=${s.eId}" id="lookExam" onclick="return '${s.submit}'=='未提交'?(alert('请先进入考试答题'),false):true">查看考试</a></td>
        </tr>

    </c:forEach>


</table>




<div class="page position4">
    <a class="first-page" href="/stu/stuExam?currentPage=${currentPage}&totalPage=${totalPage}&op=1">
        <div class="first-page-trangle"></div>
        <div class="first-page-juxing">首页</div>
    </a>
    <a class="left-page" type="button" href="/stu/stuExam?currentPage=${currentPage}&totalPage=${totalPage}&op=2">
        <div></div>
        <div></div>
    </a>
    <div class="currentPage">- 第<span id="ctp">${currentPage}</span>页 -共${totalPage}页-</div>
    <a type="button" class="right_page" href="/stu/stuExam?currentPage=${currentPage}&totalPage=${totalPage}&op=3">
        <div></div>
        <div></div>
    </a>
    <a class="last-page" href="/stu/stuExam?currentPage=${currentPage}&totalPage=${totalPage}&op=4">
        <div class="last-page-juxing">尾页</div>
        <div class="last-page-trangle"></div>
    </a>
</div>
<script type="text/javascript">
    function getFormatDate() {
        var date = new Date();
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        var dateHour= date.getHours();
        var dateMinute= date.getMinutes();
        var dateScecond= date.getSeconds();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        if(dateHour>=0&&dateHour<=9)
        {
            dateHour="0"+dateHour;
        }
        if(dateMinute>=0&&dateMinute<=9)
        {
            dateMinute="0"+dateMinute;
        }
        if(dateScecond>=0&&dateScecond<=9)
        {
            dateScecond="0"+dateScecond;
        }
        var currentDate = date.getFullYear() + "-" + month + "-" + strDate +
            " " + dateHour + ":" + dateMinute + ":" + dateScecond;
        return currentDate;
    }
</script>
</body>
</html>
