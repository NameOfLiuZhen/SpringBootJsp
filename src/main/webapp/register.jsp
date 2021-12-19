<%--
  Created by IntelliJ IDEA.
  User: lys4301
  Date: 2021/12/14
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    注册页面
    <form method="post" action="${pageContext.request.contextPath}/admin/register">
        用户名：<input type="text" name="username" />
        密码：<input type="password" name="password"/>
        <button type="submit">点击注册</button>
    </form>
</body>
</html>
