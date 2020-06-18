<%--
  Created by IntelliJ IDEA.
  User: FoxBill
  Date: 2019/12/19 0019
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>回显图片</title>
    <style type="text/css">
        div{
            width: 400px;
            margin: auto;
            background-color: bisque;
        }
    </style>
</head>
<body>
    <h1 align="center">${result}</h1>
    <div>
    <b>用户名：</b>${username}<br><br>
    <b>图片的路径为：</b>${pageContext.request.contextPath}/images/${imageurl}<br><br>
    <img src="${pageContext.request.contextPath}/images/${imageurl}" width="200" height="200">
    </div>
</body>
</html>
