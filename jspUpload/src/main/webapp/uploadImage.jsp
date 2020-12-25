<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>上传图片</title>
    <style type="text/css">
        table{
            width: 50%;
            margin: 0px auto;
            border: solid 1px black;
            border-collapse: collapse;
        }
        tr{
            height: 50px;
        }

        td{
            border: solid 1px black;
            padding: 10px;
        }
    </style>
</head>
<body>
<h1 align="center">上传图片</h1>
<form action="uploadImage" enctype="multipart/form-data" method="POST" >
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username" /></td>
        </tr>
        <tr>
            <td>上传图片：</td>
            <td>
                <input type="file" name="uploadFile" id="file" accept="image/*" onchange="imgChange(this);"/> <!--文件上传选择按钮-->
            </td>
        </tr>
        <tr>
            <td>图片预览：</td>
            <td>
                <img id="imghead" src="images/upload.jpg" width="260" height="180" /> <!--图片显示位置-->
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="上传"/>
            </td>
        </tr>
    </table>
</form>
<script type="text/javascript">
    // 实现图片预览功能
    function imgChange(obj) {
        //获取点击的文本框
        var file =document.getElementById("file");
        console.log(file);
        console.log(file.files[0])
        var imgUrl = window.URL.createObjectURL(file.files[0]);
        console.log(imgUrl);
        var img =document.getElementById('imghead');
        img.setAttribute('src',imgUrl); // 修改img标签src属性值
    };
</script>
</body>
</html>