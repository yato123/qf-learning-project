<%--
  Created by IntelliJ IDEA.
  User: 63531
  Date: 2019/6/17
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        span {
            color: red;
        }
    </style>

    <script type="text/javascript" src="../../js/jquery-1.8.2.js"></script>
    <script type="text/javascript">
        $(function () {
            var flag=false;
            $("form").submit(function () {
                if (flag) {
                    $(".input").each(function (index) {
                        if( $.trim($(this).val()) != ""){
                            flag =true;
                        }else {
                            flag = false;
                            $("span:eq("+index+")").text("*");
                        }
                    })
                }
                if (!flag){
                    alert("红色*地方不能为空")
                }
                return flag;
            })
            $("input:eq(1)").blur(function () {
                if ($(this).attr("value") == $("input:eq(2)").attr("value")){
                    flag = true;
                    $("span:eq(1)").text("")
                }else {
                    flag= false
                    $("span:eq(1)").text("密码输入不一致")
                }
            })
            $("input:eq(2)").blur(function () {
                if ($(this).attr("value") == $("input:eq(1)").attr("value")){
                    flag = true;
                    $("span:eq(1)").text("")
                }else { flag= false
                    $("span:eq(1)").text("密码输入不一致")
                }
            })
            $("input:eq(0)").blur(function (){
                $.post("/user/checkUser",
                    {username:$(this).val()},
                    function (data) {
                    if (data == 0){
                        $("span:eq(0)").html("用户名可用");
                        $("span:eq(0)").css("color","green");
                        $("input:eq(0)").css("color","green");
                    }
                    else if(data == 1){
                        $("span:eq(0)").html("用户名已存在");
                        $("span:eq(0)").css("color","red");
                        $("input:eq(0)").css("color","red");

                    }
                })
            })



        })


        $(function () {
            $("#rep").click(function () {
                window.location.href="index.jsp";
            })
        })
    </script>
    <style type="text/css">
        body{
            background: url("../../images/yoona.jpg") ;
            /*background-repeat: no-repeat;*/
            /*background-size: 100%;*/
            display: flex;
            justify-content: center;
            align-items: center;

            /*background-image: url("images/yoona.jpg");*/
        }
        #div{
            width: 400px;
            height: 300px;
            background: rgba(251, 251, 255,0.3);
            line-height: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
            border-radius: 20px;
            font-size: 20px;
            border-color: pink ;
        }
        .rgp{
            font-size: 20px;
        }
        #div2{
            text-align: center;
        }
        form{
            color: purple;
        }
        p{
            color: red;
        }
    </style>
</head>
<body>
    <div id="div">

    <form action="/user/register" method="post" accept-charset="UTF-8">
            ${msg}<br/>
     用户名:<input type="text" name="username" class="input" style="margin-top: 20px"><span></span><br/>
     密码:<input type="password" name="password" class="input"><span></span><br/>
     确认密码:<input type="password" name="pwd" class="input"><span></span><br/>
     性别:<input type="radio" name="sex" value="man" checked="checked" >男
          <input type="radio" name="sex" value="women" >女<br/>
     爱好:<input type="checkbox" name="hobbies" value="唱">唱
         <input type="checkbox" name="hobbies" value="跳">跳
         <input type="checkbox" name="hobbies" value="rap">Rap<br/>
     Email:<input type="text" name="email" class="input"><span></span><br/>
     手机号码:<input type="text" name="phone" class="input"><span></span><br/>
     地址:<select name="addrs" style="height: 30px">
             <option value="广东" >广东</option>
             <option value="广西">广西</option>
             <option value="东北">东北</option>
             <option value="湖南">湖南</option>
         </select><br/>
        <%--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
            <div id="div2">
            <input type="submit" value="注册" class="rgp"/>
        <input type="button" value="返回" id="rep" class="rgp">
            </div>
    </form>
    </div>
</body>
</html>
