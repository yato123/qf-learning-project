<%--
  Created by IntelliJ IDEA.
  User: 63531
  Date: 2019/7/5
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<table border="1" cellspacing="0" >
    <tr>
        <th>用户名</th>
        <th>性别</th>
        <th>爱好</th>
        <th>手机号码</th>
        <th>Email</th>
        <th>地址</th>
        <%--<th style="text-align: center"> 操作</th>--%>
    </tr>
    <c:forEach items="${page.list}" var="user">
        <tr>
            <td>${user.username}</td>
            <td>${user.sex}</td>
            <td>${user.hobbies}</td>
            <td>${user.phone}</td>
            <td>${user.email}</td>
            <td>${user.addrs}</td>
            <%--<td>--%>
                <%--<a href="<%=request.getContextPath()%>/UserServlet?action=delete&id=${user.id}">删除|</a>--%>
                <%--<a href="update.jsp?id=${user.id}">编辑</a>--%>
            <%--</td>--%>
        </tr>
    </c:forEach><br/>
    <%--<tr>--%>
        <%--<td colspan="7" style="text-align: center; font-size: 30px">--%>
            <%--<a href="<%=request.getContextPath()%>/insert.jsp"> 添加</a>--%>
        <%--</td>--%>
    <%--</tr>--%>
</table>
    <%@include file="userpage.jsp"%>
</body>
</html>
