<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Login page!!</h2>
<form action="/goods/upload" enctype="multipart/form-data" method="post">
    文件名：<input type="text" name="fileName"/>
    文件：<input type="file" name="file"/>
    <input type="submit" value="上传">
</form>
</body>
</html>
