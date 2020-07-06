<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AndreiPop
  Date: 4/15/2020
  Time: 8:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC shop</title>
    <style>
        body {
            background-color: lightsteelblue;
        }
    </style>
</head>
<body>
<div align="center">
    <a href="http://localhost:9001/shop/products" >
        <img src="${pageContext.request.contextPath}/resources/Products.gif"
             width="200" height="50"></a>
    <a href="http://localhost:9001/shop/categories">
        <img src="${pageContext.request.contextPath}/resources/Categories.gif"
             width="200" height="50"></a>
</div>
</body>
</html>
