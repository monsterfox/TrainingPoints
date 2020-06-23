<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>上传图片</title>
</head>
<body>
<form action="uploadServlet" enctype="multipart/form-data" method="POST" >
    <div>
        用户名：<input type="text" name="username" />
    </div>
    <div class="upload_box">
        <b>上传图片：</b>
        <input type="file" name="uploadFile" id="file" accept="image/*" onchange="imgChange(this);"/> <!--文件上传选择按钮-->
        <div id="preview">
            <img id="imghead" src="/style/images/blank.gif" width="260" height="180" /> <!--图片显示位置-->
        </div>
    </div>
    <input type="submit" value="上传"/>
</form>
<script type="text/javascript">
    // 选择图片显示
    function imgChange(obj) {
        //获取点击的文本框
        var file =document.getElementById("file");
        console.log(imgUrl);
        var imgUrl = window.URL.createObjectURL(file.files[0]);
        console.log(imgUrl);
        var img =document.getElementById('imghead');
        img.setAttribute('src',imgUrl); // 修改img标签src属性值
    };
</script>
</body>
</html>