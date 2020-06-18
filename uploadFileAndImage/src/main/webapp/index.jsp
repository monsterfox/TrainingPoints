<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
  <title>Smartupload</title>
  <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
  <style type="text/css">
      div{
          width: 400px;
          margin: auto;
          background-color: lightgoldenrodyellow;
      }

    label{
        width: 100px;
        display: inline-block;
        float: left;
    }
    #pic {
      width: 200px;
      height: 200px;
      margin: 20px auto;
      cursor: pointer;
    }
  </style>
</head>
<!-- 使用SmartUpload.jar 实现文件上传 -->
<body>
<h2 align="center">文件上传</h2>
<div>
<form action="smartUploadOne.do" method="post" enctype="multipart/form-data">
  <label>用户名：</label><input type="text" name="username" /><br><br>

  <label>上传文件1：</label><img id="pic" src="images/preview.jpg"> 
  <input id="upload" name="myfile1" accept="image/*" type="file" style="display: none" /><br><br> 
  <input type="submit" value="提交">
</form>
</div>
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