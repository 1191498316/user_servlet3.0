<%--
  Created by IntelliJ IDEA.
  User: y'd'd
  Date: 2020/10/8
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="js/1js.js"></script>
</head>
<body>
<form action="/UserServlet" method="post">
    <table align="center" width="500px" border="1">
        <tr height="40px" align="center">
            <td colspan="3"><strong>用户登录</strong></td>
        </tr>
        <tr height="40px">
            <td align="right">用户名：</td>
            <td>
                <input type="text" name="username" id="name" value=""/>
            </td>
            <td><span id="Sname"></span></td>
        </tr>
        <tr height="40px">
            <td align="right">密码：</td>
            <td>
                <input type="text" name="password" id="pass" value=""/>
            </td>
            <td><span id="Spass"></span></td>
        </tr>
        <tr height="40px">
            <td></td>
            <td>
                <input type="submit" name="comm" value="登录"/>
            </td>
            <td></td>
        </tr>
    </table>
</form>
</body>
</html>
