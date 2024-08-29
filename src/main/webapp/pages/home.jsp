<%@ page import="java.util.List" %>

<%--
  Created by IntelliJ IDEA.
  User: simonpirko
  Date: 16.07.24
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>

<jsp:include page="_bootstrap.jsp"/>
<jsp:include page="_header.jsp"/>


<core:if test="${user != null}">
<div class="container text-center">
    <div class="row py-5 align-items-center">
        <h1>CALCULATOR</h1>
        <div class="col">
            <form action="/" method="post">
                <input type="text" name="num1" placeholder="Num1">
                <input type="text" name="num2" placeholder="Num2">
                <input type="text" name="type" placeholder="Type">
                <button>Submit</button>
            </form>
        </div>
    </div>
    <div class="row align-items-center">
        <div class="col">
            <core:if test="${result != null}">
                <h2>RESULT = ${result}</h2>
            </core:if>
        </div>
    </div>
    </core:if>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</body>
</html>
