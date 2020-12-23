<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/13
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>发布考试</title>

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
        <a href="/tea/exam" id="deleteLine"><li id="act"><span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;&nbsp;考试管理</li></a>
        <a href="/tea/teaViewCourse" id="deleteLine"><li><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;&nbsp;课程</li></a>

    </ul>


</cpn>
<a href="javascript:history.go(-1);" class="return position1">
    <div class="trangle"></div>
    <div class="juxing">返回</div>
</a>
<form action="/tea/sentExam" class="createWrite">
    <div id="createWriteTitle">
        <h3>请输入课程号</h3>
        <input type="text" name="cId" class="s1">
    </div>
    <div id="createWriteContext">
        <h3>请输入截止时间</h3>
        <!--        <input type="text" name="context" class="s1">-->
        <input class="s1" name="last" id="test1">
        <input type="hidden" name="begin" value="" id="begin">
    </div>
    <!--    <div id="createWriteAnswer">-->
    <!--        <h3>题解</h3>-->
    <!--        &lt;!&ndash;        <input type="text" name="context" class="s1">&ndash;&gt;-->
    <!--        <textarea class="s1" name="answer"></textarea>-->
    <!--    </div>-->

    <input type="submit" value="确认发布" class="okSubmit" id="xpos6" onclick="getBegin()">
</form>


<script  type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;

//执行一个laydate实例

        laydate.render({
            elem: '#test1'
            ,type: 'datetime'
        });
    });
    function getBegin() {
        document.getElementById("begin").value=getFormatDate();
    }
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

