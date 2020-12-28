<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/12/28
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        body{
            background-color: #18C0DF;
        }
        table{
            border-collapse: collapse;
            border: solid 1px black;
            width: 80%;
            margin: auto;
        }
        td{
            border: solid 1px black;
        }
    </style>
</head>
<body>
    <table>
        <c:forEach items="${list}" var="content">
            <tr>
                <td>${content.content}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
