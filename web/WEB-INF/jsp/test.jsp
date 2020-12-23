<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/4/27
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--<style type="text/css">--%>
        <%--#obj{--%>
            <%--display: none;--%>
        <%--}--%>
    <%--</style>--%>
    <%--<script type="javascript">--%>
        <%--function jj() {--%>
            <%--document.getElementById(ff).innerHTML="22";--%>
        <%--}--%>
    <%--</script>--%>
    <form action="/admin/dotest">
        <textarea name="name">${name}</textarea>
        <input type="submit" value="tijiao">
    </form>
</head>
<body>
<c:set var="i" value="2" scope="session"/>
<c:set var="p" value="100" scope="request"/>
<table>
    <tr ><td>133</td></tr>
<c:forEach var="x" begin="${i}" end="${p}">


    <tr id="obj"><td>333</td></tr>
</c:forEach>
</table>
<h1 id="ff">111</h1>
<button onclick="jj()" type="button">dianwo</button>
<script type="text/javascript">
    function jj(){
        document.getElementById("ff").style.display="none";
    }

</script>
</body>
</html>
