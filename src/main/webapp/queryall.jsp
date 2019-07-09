<%@ page import="com.qf.one.userDao.userDaoImpl.GoodsInfoDaoImpl" %>
<%@ page import="entity.GoodsInfo" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 63531
  Date: 2019/6/20
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
    <%
//        GoodsInfoDaoImpl goodsInfoDao = new GoodsInfoDaoImpl();
//        List<GoodsInfo> goodsInfos = goodsInfoDao.QueryAll();
//        System.out.println(goodsInfos);
//        request.getSession().setAttribute("List", goodsInfos);
    %>


        <table border="1" cellspacing="0" >

            <tr>
                <td>商品名称:</td>
                <td>商品价格:</td>
                <td>商品介绍:</td>
                <td>商品库存:</td>
                <td>商品图片:</td>
                <td style="text-align: center"> 操作</td>
                <%--${page.list}--%>
            </tr>
            <c:forEach items="${page.list}" var="goodsInfo">
            <tr>
                <td>${goodsInfo.goodsInfo_name}</td>
                <td>${goodsInfo.goodsInfo_price}</td>
                <td>${goodsInfo.goodsInfo_description}</td>
                <td>${goodsInfo.goods_stock}</td>
                <td><img src="<%=request.getContextPath()%>/img/${goodsInfo.goodsInfo_pic}"  width="100px"></img></td>
                <td>
                    <a href="<%=request.getContextPath()%>/GoodsInfoServlet?action=delete&id=${goodsInfo.id}">删除|</a>
                    <a href="update.jsp?id=${goodsInfo.id}">编辑</a>
                </td>
            </tr>
            </c:forEach><br/>
            <tr>
                <td colspan="6" style="text-align: center; font-size: 30px">
                    <a href="<%=request.getContextPath()%>/insert.jsp"> 添加</a>
                </td>
            </tr>
        </table>
    <%@include file="page.jsp"%>

</body>
</html>
