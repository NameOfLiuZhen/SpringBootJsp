<%--
  Created by IntelliJ IDEA.
  User: ZHENGAMER
  Date: 2021/12/13
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
我是登录页面
<form action="http://localhost:2267/text/login" method="post">
    用户名：<input type="text" name="username" />
    密码：<input type="password" name="password"/>
    验证码：<input type="text" name="code"/>
    <img src="" height="80px" width="180px" alt="暂无"/>
    <button type="submit">进行提交</button>
</form>
</body>
</html>
