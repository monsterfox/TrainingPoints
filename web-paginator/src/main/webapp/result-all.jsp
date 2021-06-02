<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <style type="text/css">
        table{
            width: 60%;
            margin: auto;
            border: solid 1px sandybrown;
        }
        caption{
            font-weight: bold;
            font-size: 24px;
        }
        #dataTable td{
            border: solid 1px sandybrown;
        }
        #pageTable{
            margin-top: 10px;
        }
    </style>
</head>
<body>
<table id="dataTable">
    <caption>图书列表</caption>
    <tr align="center">
        <td><b>ID</b></td>
        <td><b>图书名称</b></td>
        <td><b>图书价格</b></td>
        <td><b>图书数量</b></td>
        <td><b>图书类别</b></td>
    </tr>

    <c:if test="${fn:length(list) < 1 || list == null}">
        <tr>
            <td colspan="5" align="center">还没有任何数据！</td>
        </tr>
    </c:if>

    <c:if test="${fn:length(list) > 0}">
        <c:forEach items="${list}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.pnum}</td>
                <td>${book.category}</td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>