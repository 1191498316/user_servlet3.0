<%@ page import="com.cs.service.impl.Userserviceimpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cs.entity.User" %>
<%@ page import="com.cs.until.PageSupport" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/9
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
<%--    <style type="text/css">--%>
<%--        <%--%>
<%--        for (int i=2;i<4;i++){--%>
<%--        %>--%>
<%--        table tr:first-child{--%>
<%--            background: #3933ff;--%>
<%--        }--%>
<%--        tr:nth-child(<%=i%>){--%>
<%--            background: #ff1e21;--%>
<%--        }--%>
<%--        tr:nth-of-type(<%=i+1%>){--%>
<%--            background: #39ff2f;--%>
<%--        }--%>
<%--        <%}%>--%>
<%--    </style>--%>

    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="js/1js.js"></script>
<%--    <script type="text/javascript">--%>
<%--            $(document).ready(  function(){--%>
<%--                $("table").attr("bgColor", "#222222"); //设置表格的背景颜色--%>
<%--                $("tr").attr("bgColor", "#3366CC"); //为单数行表格设置背景颜色--%>
<%--                $("tr:even").css("background-color", "#CC0000"); //为双数行表格设置背颜色素--%>
<%--                $("table").css("width", "300px"); //为表格添加样式，设置表格长度为300像素--%>
<%--            });--%>
<%--    </script>--%>
</head>
<body>
    <table align="center" border="1" width="600">
        <tr align="center">
            <td colspan="6"><strong>用户信息</strong>
                <a href="UserServlet?&comm=add" style="font-size: 12px">添加</a>
            </td>
        </tr>
        <tr>
            <td>编号</td>
            <td>用户名</td>
            <td>密码</td>
            <td>性别</td>
            <td>出生日期</td>
            <td>操作</td>
        </tr>
<%--        <%--%>
<%--            PageSupport  ps= (PageSupport) session.getAttribute("ps");--%>
<%--            List<User> list= (List<User>) session.getAttribute("list");--%>
<%--            for (User user : list) {--%>
<%--        %>--%>
        <c:forEach items="${lists}" var="u">
        <tr align="center">
            <td width="100">${u.id}</td>
            <td width="100">${u.username}</td>
            <td width="100">${u.password}</td>
            <td width="100">${u.sex}</td>
            <td width="100">${u.borndate}</td>

            <td width="100">
                <a href="UserServlet?id=${u.id}&comm=query">查看</a>&nbsp;
                <a href="UserServlet?id=${u.id}&comm=update">修改</a>&nbsp;
                <a href="javascript:del(${u.id})">删除</a>
            </td>
        </tr>
        </c:forEach>
<%--        <%}%>--%>
    </table>
<p align="center">
<%--    <%--%>
<%--    if (ps.getCurrentPageNo()>1){--%>
<%--    %>--%>
    <c:if test="${ps.currentPageNo>1}">
    <a href="UserServlet?indexno=1&comm=list">首页</a>
    <a href="UserServlet?indexno=${ps.currentPageNo-1}&comm=list">上一页</a>
    </c:if>
<%--    <%--%>
<%--    }--%>
<%--    if (ps.getCurrentPageNo()<ps.getTotalPageCount()){--%>

<%--    %>--%>
    <c:if test="${ps.currentPageNo<ps.totalPageCount}">
    <a href="UserServlet?indexno=${ps.currentPageNo+1}&comm=list">下一页</a>
    <a href="UserServlet?indexno=${ps.totalPageCount}&comm=list">末页</a>
    </c:if>
<%--    <%}%>--%>
    <%
//    session.setAttribute();
//    request.setAttribute();
    %>
</p>
</body>
</html>
