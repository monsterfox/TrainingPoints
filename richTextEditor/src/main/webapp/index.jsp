<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
    <script type="text/javascript" src="ckeditor/config.js"></script>
    <!--  参考地址 https://blog.csdn.net/itmyhome1990/article/details/17266045    -->
    <style type="text/css">
        input{
            display: block;
            width: 200px;
            height: 50px;
            margin:50px auto;
            text-align: center;
        }
    </style>
</head>
<body>
    <form action="content" method="post">
        <input type="hidden" name="command" value="addRTE">
        <textarea class="ckeditor" name="content1"></textarea>
        <input type="submit" value="提交">
    </form>
</body>
</html>
