<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/10
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/UserServlet" method="post">
    <table border="1" align="center" width="200">
<%--            <tr>--%>
<%--                <td>用户id：</td>--%>
<%--                <td><input type="text" name="id" value=""></td>--%>
<%--            </tr>--%>
            <tr>
                <td>姓名：</td>
                <td><input type="text" name="username" value=""></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="text" name="password" value=""></td>
            </tr>
            <tr>
                <td>性别：</td>
                <td><input type="text" name="sex" value=""></td>
            </tr>
            <tr>
                <td>出生日期：</td>
                <td><input type="text" name="borndate" value=""></td>
            </tr>
        <tr>
            <td></td>
            <td><input type="submit" name="comm" value="添加"></td>
        </tr>
    </table>
</form>
</body>
</html>
