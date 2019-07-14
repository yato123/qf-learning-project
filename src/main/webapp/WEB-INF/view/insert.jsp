<%--
  Created by IntelliJ IDEA.
  User: 63531
  Date: 2019/6/19
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form  action="GoodsInfoServlet?action=insert" method="post" enctype="multipart/form-data" >
    <div>
        商品名称:<input type="text" name="goodsInfo_name">
    </div>
    <div>
        商品价格:<input type="text" name="goodsInfo_price">
    </div>
    <div>
        商品简介:<input type="text" name="goodsInfo_description">
    </div>
    <div>
        商品库存:<input type="text" name="goods_stock">
    </div>
    <div>
        商品图片:<input type="file" name="goodsInfo_pic">
    </div>
    <input type="submit" value="添加">

</form>
</body>
</html>
