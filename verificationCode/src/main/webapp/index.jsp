<%@ page contentType="text/html;charset=utf-8" %>
<%@ page language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;
           charset=utf-8">
    <title>用户登录</title>
    <style type="text/css">
        caption {
            font: 18px bold;
        }

        tr {
            height: 60px;
        }

        div {
            color: #ffffFF;
            font-weight: bold;
            background-color: black;
            padding: 10px;
        }

        input[type="submit"] {
            width: 100px;
            height: 30px;
            font-size: 18px;
        }
    </style>
    <script language="javascript">
        function loadimage(i) { //i是为了区分多种验证码，实际使用时，可以不用这个参数。
            document.getElementById("randImage" + i).src = "image" + i + ".jsp?" + Math.random();
        }
    </script>
</head>
<body>
<form action="validate.jsp" method="post" name="loginForm">
    <table width="500" border="0" cellpadding="0" cellspacing="0" align="center">
        <!--DWLayoutTable-->
        <caption>四种验证码的实现</caption>
        <tr>
            <td>数字验证码：</td>
            <td width="118" height="22" valign="middle" align="center">
                <input type="text" name="rand" size="15">
            </td>
            <td width="138" valign="middle" align="center">
                <img alt="code..." name="randImage" id="randImage0"
                     src="image0.jsp" width="60" height="20"
                     border="1" align="absmiddle">
            </td>
            <td height="36" colspan="3" align="center" valign="middle">
                <a href="javascript:loadimage(0);">
                    看不清点我
                </a>
            </td>
        </tr>
        <tr>
            <td>英文+数字验证码：</td>
            <td width="118" height="22" valign="middle" align="center">
                <input type="text" name="rand" size="15">
            </td>
            <td width="138" valign="middle" align="center">
                <img alt="code..." name="randImage" id="randImage1"
                     src="image1.jsp" width="60" height="20"
                     border="1" align="absmiddle">
            </td>
            <td height="36" colspan="3" align="center" valign="middle">
                <a href="javascript:loadimage(1);">
                    看不清点我
                </a>
            </td>
        </tr>
        <tr>
            <td>中文验证码：</td>
            <td width="118" height="22" valign="middle" align="center">
                <input type="text" name="rand" size="15">
            </td>
            <td width="138" valign="middle" align="center">
                <img alt="code..." name="randImage" id="randImage2"
                     src="image2.jsp" width="60" height="20"
                     border="1" align="absmiddle">
            </td>
            <td height="36" colspan="3" align="center" valign="middle">
                <a href="javascript:loadimage(2);">
                    看不清点我
                </a>
            </td>
        </tr>
        <tr>
            <td>表达式验证码：</td>
            <td width="118" height="22" valign="middle" align="center">
                <input type="text" name="rand" size="15">
            </td>
            <td width="138" valign="middle" align="center">
                <img alt="code..." name="randImage" id="randImage3"
                     src="image3.jsp" width="60" height="20"
                     border="1" align="absmiddle">
            </td>
            <td height="36" colspan="3" align="center" valign="middle">
                <a href="javascript:loadimage(3);">
                    看不清点我
                </a>
            </td>
        </tr>
        <tr>
            <td height="36" colspan="4" align="center" valign="middle">
                <div>Tips:验证码的值，放在session中了！</div>
                <input type="submit" name="login" value="提交">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
