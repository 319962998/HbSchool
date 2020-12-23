<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/12
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <title>创建选择题</title>
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
        <a href="/tea/createProblem" id="deleteLine"><li id="act"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;&nbsp;创建试题</li></a>
        <a href="/tea/lookStuExam" id="deleteLine"><li><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;&nbsp;学生答卷<c:if test="${teaExamCount!=0}"><span class="badge" id="message">${teaExamCount}</span></c:if></li></a>
        <a href="/tea/exam" id="deleteLine"><li><span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;&nbsp;考试管理</li></a>
        <a href="/tea/teaViewCourse" id="deleteLine"><li><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;&nbsp;课程</li></a>

    </ul>


</cpn>

<form action="/tea/doCreateChoose" class="createChoose">
    <div id="createChooseTitle">
        <h3>请填写标题</h3>
        <input type="text" name="title" class="s1">
    </div>
    <div id="createChooseContext">
        <h3>请输入选择题内容</h3>
        <!--        <input type="text" name="context" class="s1">-->
        <textarea class="s1" name="context"></textarea>
    </div>
    <div id="createChooseChoice">
        <h3>选项A内容</h3>
        <textarea  name="A" class="s1"></textarea>
        <h3>选项C内容</h3>
        <textarea name="C" class="s1"></textarea>
        <div id="xpos4">
            <h3>选项B内容</h3>
            <textarea  name="B" class="s1"></textarea>
            <h3>选项D内容</h3>
            <textarea name="D" class="s1"></textarea>
        </div>
    </div>
    <div id="createChooseLable">
        <h3 style="color: red">答案：</h3>
        <label>
            <input type="radio" name="choice" id="optionsRadios1"
                   value="A"  style="width: 20px;height: 20px"> A
        </label>


        <label>
            <input type="radio" name="choice" id="optionsRadios2"
                   value="B" style="margin-left: 20px; width: 20px;height: 20px"> B

        </label>
        <label>
            <input type="radio" name="choice" id="optionsRadios3"
                   value="C" style="margin-left: 20px; width: 20px;height: 20px"> C

        </label>
        <label>
            <input type="radio" name="choice" id="optionsRadios4"
                   value="D" style="margin-left: 20px; width: 20px;height: 20px"> D

        </label>
    </div>
    <input type="submit" value="确认创建" class="okSubmit" id="xpos5">
</form>



<script src="vue.js"></script>
<script src="resource\layui\layui.js"></script>
<script src="resource/layui/layui.all.js"></script>
</body>
</html>

