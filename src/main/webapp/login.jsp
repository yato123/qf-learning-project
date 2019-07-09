<%--
  Created by IntelliJ IDEA.
  User: 63531
  Date: 2019/6/19
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.8.2.js"></script>
    <script type="text/javascript" >
        $(function () {
            $("#rep").click(function () {
                window.location.href="index.jsp";
            })
        })
    </script>
    <style type="text/css">
        body {
            background-image: url("images/lyr.jpg");
            text-align: center;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        #login {
            width: 400px;
            height: 280px;
            background: rgba(251, 251, 255,0.4);
            line-height: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
            border-radius: 20px;

        }
        input {
            width: 345px;
            height: 45px;
            margin-top: 10px;
            border-color: aliceblue;

        }
        input:nth-child(5){
            background-color: orange;
            color: white;
        }
    </style>

</head>
<body>
    <div id="login" >

        <form action="UserServlet?action=login" method="post">
            ${msg}
        <input type="text" placeholder="请输入用户名" name="username"  ><br/>
        <input type="password" placeholder="密码" name="password" ><br/>
        <input type="submit" value="登陆"><br/>
        <input type="button" value="返回" id="rep">
        </form>
    </div>
</body>
</html>