<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/13
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType = "text/html;charset=UTF-8" language = "java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>修改笔记</title>
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
        <a href="/teacher/teacherNotes" id="deleteLine"><li id="act"><span class="glyphicon glyphicon-file"></span>&nbsp;&nbsp;&nbsp;笔记</li></a>
        <a href="/tea/opProblem" id="deleteLine"><li><span class="glyphicon glyphicon-bell"></span>&nbsp;&nbsp;&nbsp;题库管理</li></a>
        <a href="/tea/createProblem" id="deleteLine"><li><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;&nbsp;创建试题</li></a>
        <a href="/tea/lookStuExam" id="deleteLine"><li><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;&nbsp;学生答卷<c:if test="${teaExamCount!=0}"><span class="badge" id="message">${teaExamCount}</span></c:if></li></a>
        <a href="/tea/exam" id="deleteLine"><li><span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;&nbsp;考试管理</li></a>
        <a href="/tea/teaViewCourse" id="deleteLine"><li><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;&nbsp;课程</li></a>

    </ul>


</cpn>
<a href="javascript:history.go(-1);" class="return position1">
    <div class="trangle"></div>
    <div class="juxing">返回</div>
</a>
<div id="stu-message1">
    <form action = "/teacher/doUpdateNotes" enctype="multipart/form-data" method="post">
         <div class="layui-row">

        <div class="layui-inline" style="width:30%">
            <label class="layui-form-label" style="width: 90px">笔记标题</label>
            <div class="layui-input-block">
                <input id="id" name="id" class="hidden" value="${note.id}">
                <input id="title" name="title" type="text" class="layui-input" lay-verify="title" value="${note.title}">
            </div>
        </div>

          <div class="layui-inline" style="width:20%;">
            <label class="layui-form-label" style="width: 90px">课程</label>
            <div class="layui-input-block">
               <input id="course" name="course" type="text" class="layui-input" readonly="readonly" lay-verify="title" value="${courseName.trim()}">
            </div>
        </div>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <div class="layui-inline">
             <input class="layui-btn layui-btn-sm" type="submit" value="提交">
        </div>
    </div>
    <br>
    <div class="layui-form-item layui-col-xs9 ">
            <label class="layui-form-label" style="width: 90px" >笔记内容</label>
<%--            <div class="layui-input-block">--%>
<%--                --%>
<%--            </div>--%>
             <div id="note" style="border: red">
                <img src="/download/${fileName}" alt="临时图片" style="width: 500px;height: 500px"/>
                 <textarea class="hinput" type="text" style="border:0;border-radius:5px;background-color:rgba(241,241,241,.98);width: 500px; height: 250px; resize: none; position: relative; top: 20px" name="content" cols="30" rows="10">
                     ${note.textContent}
                 </textarea>
            </div>
        <input class="hinput" type="file" id="file" name="file" style="position: absolute;top: -100px;left: 700px">
    </div>

    </form >
</div>
<script src="/vue.js"></script>
<script src="/resource/layui/layui.js"></script>
<script src="/resource/layui/layui.all.js"></script>
<script src="/resource/layui/wangEditor.js"></script>

<script type="text/javascript">
    var E = window.wangEditor
    var editor = new E('#editor')
    // 或者 var editor = new E( document.getElementById('editor') )
    editor.create()
    document.getElementById('btn1').addEventListener('click', function () {
	    // 读取 html
	    alert(editor.txt.html())
    }, false)

    document.getElementById('btn2').addEventListener('click', function () {
	    // 读取 text
	    alert(editor.txt.text())
    }, false)
</script>
</body>
</html>


