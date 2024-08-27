<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 27.08.2024
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="/user/reg" method="post">
    <input type="text" name="name" value="${user.name}" placeholder="Name">
    <input type="text" name="username" value="${user.username}" placeholder="Username">
    <input type="password" name="password" value="${user.password}" placeholder="Password">
    <button>SUBMIT</button>
</form>
</body>
</html>
