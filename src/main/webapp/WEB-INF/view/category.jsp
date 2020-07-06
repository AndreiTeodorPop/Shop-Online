<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AndreiPop
  Date: 4/13/2020
  Time: 10:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color: #ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;
            overflow:hidden;word-break:normal;border-color: #ccc;color: #333;background-color: #fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;
            border-width:1px;overflow:hidden;word-break:normal;border-color: #ccc;color: #333;background-color: #f0f0f0;}
        .tg .tg-4eph{background-color: #f9f9f9}
    </style>
</head>
<body>
<div align="center">
    <a href="http://localhost:9001/shop/homepage" >
        <img src="${pageContext.request.contextPath}/resources/Homepage.gif"
             width="150" height="50">
    </a>
    <a href="http://localhost:9001/shop/categories" >
        <img src="${pageContext.request.contextPath}/resources/Categories.gif"
             width="200" height="50">
    </a>
</div>
<h1 align="center">The products for this category are: </h1>
<table class="tg" align="center">
    <tr>
        <th width="120">Name</th>
        <th width="120">Description</th>
        <th width="80">Price</th>
    </tr>
    <c:forEach items="${listProducts}" var="product">
        <tr>
            <td align="center"><a href="http://localhost:9001/shop/product/${product.id}">
                    ${product.name}</td></a>
            <td>${product.description}</td>
            <td align="center">${product.price}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
