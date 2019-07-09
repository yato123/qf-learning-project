<%--
  Created by IntelliJ IDEA.
  User: 63531
  Date: 2019/6/17
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
      <script type="text/javascript"src="js/jquery-1.8.2.js"></script>
      <script type="text/javascript">
          $(function () {
              $("input:eq(0)").click(function () {
                  location.href="register.jsp";
              })
              $("input:eq(1)").click(function () {
                  location.href="login.jsp";
              })
          })
      </script>
      <style type="text/css">
          body{
              display: flex;
              justify-content: center;
              align-items: center;
              background-image: url("images/psb.jpg");
          }
          input{
              font-size: 30px;
              background-color: pink;
          }
      </style>
  </head>
  <body>

         <input type="button" value="注册"/>
         <input type="button" value="登陆"/>
      <%--<a href="register.jsp">注册</a>--%>
      <%--<a href="login.jsp">登陆</a>--%>

  </body>
</html>
