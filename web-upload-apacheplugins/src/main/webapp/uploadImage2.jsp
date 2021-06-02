<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>

<html>
<head>
    <title>图书上传前预览</title>
    <meta charset="UTF-8">

    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>

    <style type="text/css">
        #pic{
            width:200px;
            height:200px;
            border-radius:5%;
            margin:20px auto;
            cursor: pointer;
        }
    </style>
</head>
<body>
<img align="middle" id="pic" src="../images/preview.jpg">
<input id="upload" name="file" accept="image/*" type="file" style="display: none" />
点击图片，可以上传图片，并预览。 
<script type="text/javascript">
    $(function() {
        $("#pic").click(function() {
            $("#upload").click(); //隐藏了input:file样式后，点击头像就可以本地上传
            $("#upload").on("change", function() {
                var objUrl = getObjectURL(this.files[0]); //获取图片的路径，该路径不是图片在本地的路径
                if (objUrl) {
                    $("#pic").attr("src", objUrl); //将图片路径存入src中，显示出图片
                }
            });
        });
    });


    //建立一個可存取到該file的url
    function getObjectURL(file) {
        var url = null;
        if (window.createObjectURL != undefined) { // basic
            url = window.createObjectURL(file);
        } else if (window.URL != undefined) { // mozilla(firefox)
            url = window.URL.createObjectURL(file);
        } else if (window.webkitURL != undefined) { // webkit or chrome
            url = window.webkitURL.createObjectURL(file);
        }
        return url;
    }
</script>
</body>

</html>