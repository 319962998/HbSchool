<%@ page import="java.util.List" %>
<%@ page import="com.colin.bean.Course" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/4/20
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/ss.css" >

    <title>课程管理</title>

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
<div class="home">
    <img src="../../img/home.png" >
    <div>我的桌面</div>
</div>
<div class="lay">
    <div class="lay1">课程总数<div class="lay-number">${totalCourse}</div></div>
    <div class="lay2">欠费人数<div class="lay-number">${totalPeople}</div></div>
    <div class="lay3">待发工资<div class="lay-number">${totalPay} </div></div>
    <div class="lay4">学生人数<div class="lay-number">${totalUser}</div></div>
</div>
<form action="/admin/serchCourse" class="serch">
    <input type="text" class="s1" name="cId" id="cId" placeholder="课号"/>
    <input type="text" name="cName" class="s1" id="cName" placeholder="课名"/>
    <input type="text" name="tName" class="s1" id="tName" placeholder="教师名"/>
    <input type="submit" class="s1 s2" value="  "/>
</form>
<table class="opcourse-table">
    <tr class="s1">
        <td class="alt">课号</td>
        <td class="alt">课名</td>
        <td class="alt">教师费</td>
        <td class="alt">学生费</td>
        <td class="alt">上课教师</td>

        <td class="alt">上课时间</td>
        <td class="alt">上课累计</td>
        <td class="alt">待结算课时</td>
        <td class="alt" colspan="5">操作</td>

    </tr>



    <c:forEach items="${list}" var="s" varStatus="abc" >

        <tr>
            <td class="s1">${s.id}</td>
            <td class="s1">${s.name}</td>
            <td class="s1">${s.tPay}</td>
            <td class="s1">${s.sPay}</td>
            <td class="s1">${s.tName}</td>
            <td class="s1">${s.time}</td>
            <td class="s1">${s.totalClass}</td>
            <td class="s1">${s.payClass}</td>
            <td><a class="tap1" onclick="openInsert(${s.id})">增加</a></td>
            <td><a href="/admin/lookHistory?courseid=${s.id}&opreduce=1" class="tap2">减少</a></td>
            <td><a href="/admin/fresh?id=${s.id}" class="tap3" onclick="return ifFresh()">清零</a></td>
            <td><a href="/admin/lookHistory?courseid=${s.id}" class="tap4">查看</a></td>
            <td><a href="/admin/deleteCourse?id=${s.id}" class="tap5" onclick="return ifDelete()">删除</a></td>
        </tr>

    </c:forEach>

</table>
<div class="page" id="page1">
    <a class="first-page" href="/admin/opCoursePage?currentPage=${currentPage}&op=1">
        <div class="first-page-trangle"></div>
        <div class="first-page-juxing">首页</div>
    </a>
    <a class="left-page" href="/admin/opCoursePage?currentPage=${currentPage}&op=2">
        <div></div>
        <div></div>
    </a>
    <div class="currentPage">- 第<span id="ctp">${currentPage}</span>页 -共${totalPage}页-</div>
    <a class="right_page" href="/admin/opCoursePage?currentPage=${currentPage}&op=3">
        <div></div>
        <div></div>
    </a>
    <a class="last-page" href="/admin/opCoursePage?currentPage=${currentPage}&op=4">
        <div class="last-page-juxing">尾页</div>
        <div class="last-page-trangle"></div>
    </a>
</div>
<div class="page" id="page2">
    <a class="first-page" href="/admin/serchCoursePage?currentPage=${currentPage}&op=1&cId=${cId}&cName=${cName}&tName=${tName}">
        <div class="first-page-trangle"></div>
        <div class="first-page-juxing">首页</div>
    </a>
    <a class="left-page" href="/admin/serchCoursePage?currentPage=${currentPage}&op=2&cId=${cId}&cName=${cName}&tName=${tName}">
        <div></div>
        <div></div>
    </a>
    <div class="currentPage">- 第<span id="ctp">${currentPage}</span>页 -共${totalPage}页-</div>
    <a class="right_page" href="/admin/serchCoursePage?currentPage=${currentPage}&op=3&cId=${cId}&cName=${cName}&tName=${tName}">
        <div></div>
        <div></div>
    </a>
    <a class="last-page" href="/admin/serchCoursePage?currentPage=${currentPage}&op=4&cId=${cId}&cName=${cName}&tName=${tName}">
        <div class="last-page-juxing">尾页</div>
        <div class="last-page-trangle"></div>
    </a>
</div>
<%--<form action="OpCourseSerchServlet" class="serchPage">--%>
    <%--<input type="text" class="s1 serchPage-width" name="toPage" placeholder="跳转到"/>--%>

    <%--<input type="submit" class="s1 s2" value="  "/>--%>
    <%--<input type="hidden" name="tap" value="${tap}">--%>
    <%--<input type="hidden" name="c_id" value="${c_id}">--%>
    <%--<input type="hidden" name="c_name" value="${c_name}">--%>
    <%--<input type="hidden" name="t_name" value="${t_name}">--%>
    <%--<input type="hidden" name="currentPage" value="${currentPage}">--%>
<%--</form>--%>

<div class="alertInsert" id="alertInsert">
    <form action="/admin/increaseCourse" class="alertCs" onsubmit="return ifleaveSubmit()">
        <div class="middle">
            <h3>请输入请假人数</h3>
            <input type="text" class="s1" name="totalLeave" id="totalLeave">
            <h5 id="leavePeople">请假人数未输入</h5>
            <h3>请填写本堂上课时间</h3>
            <input type="text" value=" " id="time" class="s1" name="time">
            <input type="submit" id="leaveSubmit" value="确认添加" class="leaveSubmit"/>
            <button type="button" class="cancleLeave" onclick="cancelLeave()">取消</button>
            <input type="hidden" name="leaveCourseid" id="leaveCourseid" value=""/>
        </div>

    </form>
</div>
<div class="alertCs" id="alertInsert1">
    <a href="javascript:history.go(-1);" class="return position1">
        <div class="trangle"></div>
        <div class="juxing">返回</div>
    </a>
    <form action="/admin/leavePeople" class="selectStudent whiteBack pos1">
        <h3>请输入${totalLeave}个学生学号和姓名</h3>
        <br>
        <table class="selectStudent-table">

            <c:forEach var="i" begin="1" end="${totalLeave}" varStatus="x">
                <tr>
                    <td class="selectId">${x.index}</td>
                    <td>学号</td><td><input type="text" class="s1" name="id${x.index}" placeholder="重名时填写"></td>
                    <td>姓名</td><td><input type="text" class="s1" name="name${x.index}"></td>
                </tr>
            </c:forEach>


        </table>
        <input type="submit" value="完成添加" class="s1 s4"/>
        <!-- <input type="text" class="s1" name="c_id" placeholder="课号"/>
        <input type="text" name="c_name" class="s1" placeholder="课名"/>
        <input type="submit" class="s1 s2" value="  "/> -->
        <input type="hidden" name="totalLeave" value="${totalLeave}">
        <input type="hidden" name="cId" value="${leaveCourseid}"/>
        <input type="hidden" name="history" value="${time}"/>

    </form>
    <form action="" class="chooseStudent whiteBack pos2">
        <h3>搜索学生学号</h3><br>
        <input type="text" class="s1" name="cId" placeholder="学号"/>
        <input type="text" name="cName" class="s1" placeholder="姓名"/>
        <input type="submit" class="s1 s2" value="  "/>
    </form>
    <table class="chooseStudent-table whiteBack pos3">
        <tr>
            <td>学号</td>
            <td>姓名</td>
            <td>学校</td>
            <td>手机号</td>
            <td>学费</td>
            <td>备注</td>
        </tr>

    </table>
</div>

<script type="text/javascript">



    <%--if(${tap}==2)--%>
    <%--{--%>
        <%--document.getElementById("c_id").value="${c_id}";--%>
    <%--}--%>
    <%--if(${tap}==3)--%>
    <%--{--%>

        <%--document.getElementById("c_name").value="${c_name}";--%>
    <%--}--%>
    <%--if(${tap}==4)--%>
    <%--{--%>
        <%--document.getElementById("t_name").value="${t_name}";--%>
    <%--}--%>
    if("${tap}"=="1")
    {
        document.getElementById("page1").style.display="block";
        document.getElementById("page2").style.display="none";
    }
    if("${tap}"=="2")
    {
        document.getElementById("page1").style.display="none";
        document.getElementById("page2").style.display="block";
        document.getElementById("cId").value="${cId}";
        document.getElementById("cName").value="${cName}";
        document.getElementById("tName").value="${tName}";
    }
    document.getElementById("alertInsert").style.display="none";
    document.getElementById("alertInsert1").style.display="none";
    if("${opLeave}"=="1")
    {
        document.getElementById("alertInsert").style.display="none";
        document.getElementById("alertInsert1").style.display="block";
    }
    function openInsert(c_id)
    {
        var date = new Date();

        var year = date.getFullYear();

        var month = date.getMonth()+1;
        var day = date.getDate();
        var hour = date.getHours();
        var minute = date.getMinutes();
        var second = date.getSeconds();
        var nowtime= year+'年'+month+'月'+day+'日 '+hour+':'+minute+':'+second;
        document.getElementById("alertInsert").style.display="block";
        document.getElementById("time").value=nowtime;
        document.getElementById("leaveCourseid").value=c_id;
    }
    function openSelect()
    {
        document.getElementById("alertInsert").style.display="none";
        document.getElementById("alertInsert1").style.display="block";
    }
    function cancelLeave()
    {
        document.getElementById("alertInsert").style.display="none";
    }

    function ifleaveSubmit()
    {
        if(document.getElementById("totalLeave").value==null||document.getElementById("totalLeave").value=="")
        {

            document.getElementById("leavePeople").style.display="block";
            return false;
        }
        else
        {
            return true;
        }

    }
    function ifFresh() {
        var a=prompt("请输入密码:");
        if(a=="555")
            return true;
        else
        {
            alert("密码错误");
            return false;
        }
    }
    function ifDelete() {
        var a=prompt("请输入密码:");
        if(a=="555")
            return true;
        else
        {
            alert("密码错误");
            return false;
        }
    }
</script>

</body>
</html>

