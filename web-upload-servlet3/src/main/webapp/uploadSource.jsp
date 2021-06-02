<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>上传文件</title>
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
<h1 align="center">上传文件</h1>
<form action="uploadFile" enctype="multipart/form-data" method="POST" >
    <table>
        <tr>
            <td>上传文件：</td>
            <td>
                <input type="file" name="uploadFile" id="file" />
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="上传"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>