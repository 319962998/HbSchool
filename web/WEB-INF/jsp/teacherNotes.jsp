<%@ page import = "java.util.Date" %><%@ page import = "com.colin.bean.Note" %><%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %><%@ taglib
        prefix = "C"
        uri = "http://java.sun.com/jsp/jstl/core"
%>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/13
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType = "text/html;charset=UTF-8" language = "java" %>
<style >
    /* 表格及内部元素样式 */


    table, td {
        border-style: solid;
        border-color: rgba(0, 0, 0, 0.164);
        border-width: 1px;
        border-collapse: collapse;
        text-align: center;
    }

    td {
        width: 150px;
        height: 30px;
    }

    thead {
        background-color: rgba(0, 0, 0, 0.068);
    }

</style >

<html >
<head >
    <meta charset = "utf-8">
    <title >教师笔记</title >
    <link rel = "stylesheet" type = "text/css" href = "/stu.css" />
    <link rel = "stylesheet" type = "text/css" href = "/ss.css">


    <link rel = "stylesheet" href = "https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel = "stylesheet" href = "/resource/layui/css/layui.css">
    <link rel = "stylesheet" href = "/resource/layui/css/layui.mobile.css">

    <script src = "/resource/layui/layui.js"></script >
    <script src = "https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script >
    <script src = "https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script >


    <script >
        // 全选
        function checkAll() {
	        var es = document.getElementsByClassName('checkToDelect')
	        for (var i = 0; i < es.length; i++) {
		        es.item(i).checked = true;
	        }
        }

        //全部取消
        function disCheckAll() {
	        var es = document.getElementsByClassName('checkToDelect')
	        for (var i = 0; i < es.length; i++) {
		        es.item(i).checked = false;
	        }
        }
    </script >

</head >
<body >
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
        <a href="/teacher/teacherNotes" id="deleteLine"><li id="act"><span class="glyphicon glyphicon-file"></span>&nbsp;&nbsp;&nbsp;笔记</li></a>
        <a href="/tea/opProblem" id="deleteLine"><li><span class="glyphicon glyphicon-bell"></span>&nbsp;&nbsp;&nbsp;题库管理</li></a>
        <a href="/tea/createProblem" id="deleteLine"><li><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;&nbsp;创建试题</li></a>
        <a href="/tea/lookStuExam" id="deleteLine"><li><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;&nbsp;学生答卷<c:if test="${teaExamCount!=0}"><span class="badge" id="message">${teaExamCount}</span></c:if></li></a>
        <a href="/tea/exam" id="deleteLine"><li><span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;&nbsp;考试管理</li></a>
        <a href="/tea/teaViewCourse" id="deleteLine"><li><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;&nbsp;课程</li></a>

    </ul>


</cpn>
<div id = "stu-message">

    <div class = "layui-inline" style = "margin-left:30px; position: relative; top: 20px;">
        <a class = "layui-btn layui-btn-normal addNotice_btn" href = "/teacher/writeNotes">写笔记</a >
    </div >

    <form action = "/teacher/deleteSelect">
        <div class = "layui-inline" style = "position: relative; bottom: 19px; left: 150px;">
            <input type = "submit" value = "批量删除" class = "layui-btn layui-btn-danger layui-btn-normal delAll_btn" />
        </div >

        <table id = "noticeList" lay-filter = "noticeList">
            <thead >
            <tr >
                <td > <div
                        onclick = "checkAll()"
                        class = "layui-btn layui-btn-xs layui-btn-danger"
                        lay-event = "del"
                >全选</div >
                    <div onclick = "disCheckAll()" class = "layui-btn layui-btn-xs layui-btn-danger" lay-event = "del">取消</div ></td >
<%--                <td >ID</td >--%>
                <td >笔记标题</td >
                <td >发布者</td >
                <td >发布时间</td >
                <td >对应课程</td >
                <td >操作</td >
            </tr >
            </thead >
            <tbody >
            <c:forEach var = "note" items = "${notes}">
                <tr>
                    <td > <input type = "checkbox" class = "checkToDelect" name = "checkbox" value = "${note.id}"> </td >
<%--                <td >${note.id}</td >--%>
               <td >${note.title}</td >
                <td >${teacher.name}</td >
                <td style="font-size:smaller">${note.date}</td >
                    <c:forEach items="${courses}" var="course">
                       <c:choose>
                           <c:when test="${course.id==note.course.id}">
                                <td>${course.name}</td>
                           </c:when>
                       </c:choose>
                    </c:forEach>
<%--                <td >${note.id}</td >--%>
<%--                <td >${note.course.id}</td >--%>
                <td > <a class = "layui-btn layui-btn-xs layui-btn-danger" lay-event = "del" href="/teacher/deleteOne?noteId=${note.id}">删除</a >
                    <a class = "layui-btn layui-btn-xs" lay-event = "edit"
                       href = "/teacher/updateNotes?noteId=${note.id}&noteTitle=${note.title}&noteContent=${note.textContent}&courseName=
                    <c:forEach items="${courses}" var="course">
                       <c:choose>
                           <c:when test="${course.id==note.course.id}">
                                ${course.name}
                           </c:when>
                       </c:choose>
                    </c:forEach>">修改</a >
                    <a class = "layui-btn layui-btn-xs layui-btn-primary"  lay-event = "look" href = "/teacher/viewNotes?id=${note.id}">查看</a >
                </td >
                </tr>

            </c:forEach >

            </tbody >
        </table >
    </form >
       <div class="page" id="notePage">
    <a class="first-page" href="/teacher/teacherNotes?currentPage=1">
        <div class="first-page-trangle"></div>
        <div class="first-page-juxing">首页</div>
    </a>
    <a class="left-page" href="/teacher/teacherNotes?currentPage=${pageBean.currentPage-1}">
        <div></div>
        <div></div>
    </a>
    <div class="currentPage">- 第<span id="ctp">${pageBean.currentPage }</span>页 -共${pageBean.totalPage }页-</div>
    <a class="right_page" href="/teacher/teacherNotes?currentPage=${pageBean.currentPage+1}">
        <div></div>
        <div></div>
    </a>
    <a class="last-page" href="/teacher/teacherNotes?currentPage=${pageBean.totalPage}">
        <div class="last-page-juxing">尾页</div>
        <div class="last-page-trangle"></div>
    </a>
</div>
</div >

<script src = "/vue.js"></script >
<script src = "/resource/layui/layui.js"></script >
<script src = "/resource/layui/layui.all.js"></script >
</body >
</html >
