<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/14
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>选择题考试界面</title>
    <script src="/resource/layui/layui.js"></script>
    <link rel="stylesheet" type="text/css" href="/stu.css"/>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/ss.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <link rel="stylesheet" href="/resource/layui/css/layui.css">
    <link rel="stylesheet" href="/resource/layui/css/modules/laydate/default/laydate.css">

</head>
<body>

<a href="/stu/stuExam" class="return position1" id="r1">
    <div class="trangle"></div>
    <div class="juxing">退出</div>
</a>
<a href="/tea/lookStuExam" class="return position1" id="r2">
    <div class="trangle"></div>
    <div class="juxing">退出</div>
</a>

<form action="/stu/StuExamPage" class="createChoose"  enctype="multipart/form-data" method="post">
    <input type="hidden" name="currentExam" value="${currentExam}">
    <input type="hidden" name="totalExam" value="${totalExam}">
    <div id="createChooseTitle">
        <h3>标题</h3>
        <input type="text" name="title" class="s1" readonly value="${problem.title}">
    </div>
    <div id="createChooseContext">
        <h3>选择题内容</h3>
        <!--        <input type="text" name="context" class="s1">-->
        <textarea class="s1" name="context" readonly>${problem.context}</textarea>
    </div>
    <div id="createChooseChoice">
        <h3>选项A</h3>
        <textarea  name="A" class="s1" readonly>${problem.a}</textarea>
        <h3>选项C</h3>
        <textarea name="C" class="s1" readonly>${problem.c}</textarea>
        <div id="xpos4">
            <h3>选项B</h3>
            <textarea  name="B" class="s1" readonly>${problem.b}</textarea>
            <h3>选项D</h3>
            <textarea name="D" class="s1" readonly>${problem.d}</textarea>
        </div>
    </div>
    <input type="file" name="file" id="hiddenFile">
    <div id="createChooseLable">
        <h3 style="color: red" id="answer">答案：${problem.answer}</h3>
        <label>
            <input type="radio" name="answer" id="op1" value="A"  style="width: 20px;height: 20px" onclick="return ifChoose()"> A
        </label>


        <label>
            <input type="radio" name="answer" id="op2" value="B" style="margin-left: 20px; width: 20px;height: 20px" onclick="return ifChoose()"> B

        </label>
        <label>
            <input type="radio" name="answer" id="op3" value="C" style="margin-left: 20px; width: 20px;height: 20px" onclick="return ifChoose()"> C

        </label>
        <label>
            <input type="radio" name="answer" id="op4" value="D" style="margin-left: 20px; width: 20px;height: 20px" onclick="return ifChoose()"> D

        </label>
    </div>
    <input type="submit" value="确认提交" class="okSubmit" id="xpos14" name="okSubmit">
    <div class="page" id="xpos10">

        <button type="submit" class="left-page" name="op" value="2">
            <div></div>
            <div></div>
        </button>
        <div class="currentPage">- 第<span id="ctp">${currentExam}</span>题 -共${totalExam}题-</div>
        <button type="submit" class="right_page" name="op" value="3">
            <div></div>
            <div></div>
        </button>


    </div>
</form>




<script type="text/javascript">
    document.getElementById("answer").style.display="none";
    document.getElementById("xpos14").style.display="none";
    document.getElementById("hiddenFile").style.display="none";
    document.getElementById("r2").style.display="none";
    self.setInterval("clock()",1000);
    function ifChoose() {
        if("${tap}"=="2"||clock()==-1)
        {
            return false;
        }
        else return true;
    }
    if("${tap}"=="2")
    {
        document.getElementById("answer").style.display="block";

    }
    if("${tap}"=="1")
    {
        document.getElementById("xpos14").style.display="block";
    }
    var choices=document.getElementsByName("answer");
    for (var i = 0; i < choices.length; i++) {

        if (choices[i].value=="${stuAnswer}")
        {
            choices[i].checked= true;
        }
    }
    if("${sessionTeacher.id}"!="")
    {
        document.getElementById("r2").style.display="block";
        document.getElementById("r1").style.display="none";
    }

    function clock()
    {
        var time=getFormatDate();
        if(time>'${sessionLast}')
        {
            return -1;
        }
        else return 1;
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
