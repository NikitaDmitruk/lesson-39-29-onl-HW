<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 27.08.2024
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>History</title>
</head>
<body>
<jsp:include page="_bootstrap.jsp"/>
<jsp:include page="_header.jsp"/>
<h2>${user.username}'s operations</h2>
<ol>
    <core:forEach var="operation" items="${operations}">
        <li>${operation}</li>
    </core:forEach>
</ol>
</body>
</html>
