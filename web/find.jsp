<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/10
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function aa() {
            history.back();
        }
    </script>
</head>
<body>
    <form method="post">
        <table border="1" align="center" width="200">
            <tr>
                <td>用户id：</td>
                <td>${u.id}</td>
            </tr>
            <tr>
                <td>姓名：</td>
                <td>${u.username}</td>
            </tr>
            <tr>
                <td>密码：</td>
                <td>${u.password}</td>
            </tr>
            <tr>
                <td>性别：</td>
                <td>${u.sex}</td>
            </tr>
            <tr>
                <td>出生日期：</td>
                <td>${u.borndate}</td>
            </tr>
            <tr>
                <td></td>
                <td><input type="button" value="返回" onclick="aa()"></td>
            </tr>
        </table>
    </form>
</body>
</html>
