<%--
  Created by IntelliJ IDEA.
  User: 63531
  Date: 2019/7/6
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="${page.url}?action=userPage&currentPage=1">首页</a>
    <c:if test="${page.currentPage>1}">
        <a href="${page.url}?action=userPage&currentPage=${page.currentPage-1}">上一页</a>
    </c:if>
    <c:if test="${page.currentPage < page.pageCount}">
        <a href="${page.url}?action=userPage&currentPage=${page.currentPage+1}">下一页</a>
    </c:if>
    <a href="${page.url}?action=userPage&currentPage=${page.pageCount}">尾页</a><br/>
    <a href="index2.jsp">回到展示选择</a>
</body>
</html>
