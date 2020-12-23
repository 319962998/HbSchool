<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/4/18
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>



<head>

    <meta charset="UTF-8">
    <%--<link rel="stylesheet" type="text/css" href="/css/login.css"/>--%>
    <link rel="stylesheet" href="/login.css" >
    <title>登录</title>


</head>

<body>

<div class="sign-div">

    <form class="" action="/admin/login" method="post">

        <h1>红博文化学校</h1>

        <h2>登录</h2>

        <input class="sign-text" type="text" placeholder="用户名" name="name">
        <h5 style="color: red" id="namewrong">用户名不存在</h5>
        <input class="sign-text" type="password" placeholder="密码" name="password">
        <h5 style="color: red" id="passwordwrong">密码错误</h5>

        <input class="sign-btn" type="submit" value="完成">

        <a href="/admin/sign">注册用户</a>

    </form>



</div>




<script type="text/javascript">
    document.getElementById("namewrong").style.display="none";
    document.getElementById("passwordwrong").style.display="none";
    if("${logtap}"=="1")
    {
        document.getElementById("namewrong").style.display="block";

    }
    if("${logtap}"=="2")
    {
        document.getElementById("passwordwrong").style.display="block";

    }
</script>
</body>


</html>