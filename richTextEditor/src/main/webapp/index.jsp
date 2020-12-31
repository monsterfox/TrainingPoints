<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
    <script type="text/javascript" src="ckeditor/config.js"></script>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <!--  参考地址 https://blog.csdn.net/itmyhome1990/article/details/17266045    -->
    <style type="text/css">
        input{
            display: block;
            width: 200px;
            height: 50px;
            margin:50px auto;
            font-size: 24px;
            text-align: center;
        }
    </style>
</head>
<body>
    <form action="content" method="post">
        <input type="hidden" name="command" value="addRTE">
        <textarea name="content" id="content"></textarea>
        <input type="submit" value="提交">
    </form>
<script>
    $(document).ready(function(){
        /*
            height：高度
            width：宽度
            filebrowserImageUploadUrl：要上传的action或servlet
         */
        CKEDITOR.replace('content', { height: '500px', width: '100%',filebrowserImageUploadUrl:'ImgUpload.action' });
    });
</script>
</body>
</html>
