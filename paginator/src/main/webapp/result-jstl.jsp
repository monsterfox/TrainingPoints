<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ page import="java.util.*" %>
<%@ page import="com.foxbill.domain.Book" %>
<%@ page import="com.foxbill.domain.PageModel" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- <script src="/haha/js/jquery.min.js" type="text/javascript"></script> -->
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
    <c:if test="${pageModel.list == null || fn:length(pageModel.list) < 1}">
        <tr>
            <td colspan="5" align="center">还没有任何数据！</td>
        </tr>
    </c:if>
    <c:if test="${pageModel.list != null && fn:length(pageModel.list) > 0}">
        <c:forEach items="${pageModel.list}" var="rec">
            <tr>
                <td>${rec.id}</td>
                <td>${rec.name}</td>
                <td>${rec.price}</td>
                <td>${rec.pnum}</td>
                <td>${rec.category}</td>
            </tr>
        </c:forEach>
    </c:if>
</table>
<form name="form1" action="${pageContext.request.contextPath}/getBook" method="post">
    <TABLE id="pageTable">
        <TR>
            <TD align="left">
                共${pageModel.totalRecords}条/<a>每页</a>
                <select name="pageSize"
                        onchange="document.all.pageNo.value='1';document.all.form1.submit();">
                    <option value="5" <c:if test="${pageModel.pageSize == 5}">selected="selected"</c:if>>5</option>
                    <option value="10" <c:if test="${pageModel.pageSize == 10}">selected="selected"</c:if>>10</option>
                    <option value="20" <c:if test="${pageModel.pageSize == 20}">selected="selected"</c:if>>20</option>
                    <option value="30" <c:if test="${pageModel.pageSize == 30}">selected="selected"</c:if>>30</option>
                </select>条</TD>
            <TD align="right">
                <a href="javascript:document.all.pageNo.value='1';document.all.form1.submit();">首页</a>
                <a href="javascript:document.all.pageNo.value='${pageModel.previousPageNo}';document.all.form1.submit();">上一页</a>
                <a href="javascript:document.all.pageNo.value='${pageModel.nextPageNo}';document.all.form1.submit();">下一页</a>
                <a href="javascript:document.all.pageNo.value='${pageModel.totalPages}';document.all.form1.submit();">尾页</a>
                <a>第</a>
                <select name="pageNo" onchange="document.all.form1.submit();">
                    <c:forEach var="i" begin="1" end="${pageModel.totalPages}">
                        <option value="${i}" <c:if test="${pageModel.pageNo == i}">selected="selected"</c:if>>${i}</option>
                    </c:forEach>
                </select><a>页</a>/共${pageModel.totalPages}页</TD>
        </TR>
    </TABLE>
</form>
</body>
</html>