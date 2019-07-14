<%@ page import="com.qf.one.userDao.userDaoImpl.GoodsInfoDaoImpl" %>
<%@ page import="entity.GoodsInfo" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 63531
  Date: 2019/6/20
  Time: 21:09
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

         GoodsInfoDaoImpl goodsInfoDao = new GoodsInfoDaoImpl();
         GoodsInfo goodsInfo = goodsInfoDao.Query(Integer.valueOf(request.getParameter("id")));
         request.getSession().setAttribute("GoodsInfo",goodsInfo);
//         1.从数据库查该商品
//         2.把获取的商品实体信息放入session
//         3.el获取该sesion里的值
     %>

<form  action="GoodsInfoServlet?action=update&&goodsInfo_id=<%=request.getParameter("id")%>" method="post" enctype="multipart/form-data" >

    <div>
        商品名称:<input type="text" value="${GoodsInfo.goodsInfo_name}" name="goodsInfo_name">
    </div>
    <div>
        商品价格:<input type="text" value="${GoodsInfo.goodsInfo_price}" name="goodsInfo_price">
    </div>
    <div>
        商品简介:<input type="text" value="${GoodsInfo.goodsInfo_description}" name="goodsInfo_description">
    </div>
    <div>
        商品库存:<input type="text" value="${GoodsInfo.goods_stock}" name="goods_stock">
    </div>
    <div>
        <img src="<%=request.getContextPath()%>/img/${GoodsInfo.goodsInfo_pic}"width="100px">
    </div>
    <div>
        商品图片:<input type="file" value="${GoodsInfo.goodsInfo_pic}" name="goodsInfo_pic">
    </div>
    <input type="submit" value="修改">

</form>

</body>
</html>
