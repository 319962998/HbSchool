<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/4/18
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >



<head>

    <meta charset="UTF-8">

    <title>教师注册</title>
    <link rel="stylesheet" href="/login.css"/>


</head>

<body>

<div class="sign-div">

    <form class="" action="/admin/insertTeacher" method="post">

        <h1>红博文化学校</h1>

        <h2>教师注册</h2>

        <input class="sign-text" type="text" placeholder="所教科目" name="subject">

        <%--<input class="sign-text" type="password" placeholder="密码" name="password">--%>

        <input class="sign-text" type="text" placeholder="电话" name="phone">
        <input class="sign-text" type="text" placeholder="备注" name="note">



        <input class="sign-btn" type="submit" value="完成注册">
        <input class="sign-text" type="hidden" value="${requestScope.name}" name="name">

        <input class="sign-text" type="hidden" value="${requestScope.password}" name="password">
    </form>



</div>





</body>


</html>