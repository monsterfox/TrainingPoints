<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ page import="java.util.*" %>
<%@ page import="com.foxbill.domain.Book" %>
<%@ page import="com.foxbill.domain.PageModel" %>

<%
//    String pageSize = (String) request.getAttribute("pageSize");
//    String pageNo = (String) request.getAttribute("pageNo");
    PageModel<Book> pageModel=(PageModel<Book>) request.getAttribute("pageModel");
    List<Book> list=pageModel.getList();
%>
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

    <%
        if(list==null||list.size()<1){
    %>
    <tr>
        <td colspan="5" align="center">还没有任何数据！</td>
    </tr>
    <%}else{
        for(Book rec:list){
    %>
    <tr>
        <td><%=rec.getId() %></td>
        <td><%=rec.getName() %></td>
        <td><%=rec.getPrice() %></td>
        <td><%=rec.getPnum() %></td>
        <td><%=rec.getCategory() %></td>
    </tr>
    <%
            }
        }
    %>

</table>
<form name="form1" action="${pageContext.request.contextPath}/getBook" method="post">
    <TABLE id="pageTable">
        <TR>
            <TD align="left">
                共<%=pageModel.getTotalRecords()%>条/<a>每页</a>
                <select name="pageSize"
                        onchange="document.all.pageNo.value='1';document.all.form1.submit();">
                    <option value="5" <%if(pageModel.getPageSize() == 5){%>
                            selected="selected" <%}%>>5</option>
                    <option value="10" <%if(pageModel.getPageSize() == 10){%>
                            selected="selected" <%}%>>10</option>
                    <option value="20" <%if(pageModel.getPageSize() == 20){%>
                            selected="selected" <%}%>>20</option>
                    <option value="30" <%if(pageModel.getPageSize() == 30){%>
                            selected="selected" <%}%>>30</option>
                </select>条</TD>
            <TD align="right">
                <a href="javascript:document.all.pageNo.value='1';document.all.form1.submit();">首页</a>
                <a href="javascript:document.all.pageNo.value='<%= pageModel.getPreviousPageNo() %>';document.all.form1.submit();">上一页</a>
                <a href="javascript:document.all.pageNo.value='<%= pageModel.getNextPageNo()%>';document.all.form1.submit();">下一页</a>
                <a href="javascript:document.all.pageNo.value='<%= pageModel.getTotalPages()%>';document.all.form1.submit();">尾页</a>
                <a>第</a>
                <select name="pageNo" onchange="document.all.form1.submit();">
                    <%
                        int pageCount = pageModel.getTotalPages();
                    %>
                    <%
                        for (int i = 1; i <= pageCount; i++) {
                    %>
                    <option value="<%=i%>" <%if(pageModel.getPageNo() == i){%>
                            selected="selected" <%}%>><%=i%></option>
                    <%
                        }
                    %>
                </select><a>页</a>/共<%=pageModel.getTotalPages()%>页</TD>
        </TR>
    </TABLE>

</form>
</body>
</html>