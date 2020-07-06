<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AndreiPop
  Date: 4/15/2020
  Time: 8:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
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
    <a href="http://localhost:9001/shop/products/" >
        <img src="${pageContext.request.contextPath}/resources/Products.gif"
             width="200" height="50">
    </a>
    <a href="http://localhost:9001/shop/categories/" >
        <img src="${pageContext.request.contextPath}/resources/Categories.gif"
             width="200" height="50">
    </a>
</div>
<h1 align="center">The product detailed characteristics are: </h1>
<table class="tg" align="center">
    <tr>
        <th width="120">Name</th>
        <th width="120">Description</th>
        <th width="80">Price</th>
        <th width="150">Reviews</th>
        <th width="120">Detailed characteristics</th>
    </tr>
    <tr>
        <td align="center">${product.name}</td>
        <td>${product.description}</td>
        <td align="center">${product.price}</td>
        <td>
            <c:forEach items="${product.reviewList}" var="review">
                <p>Rating: ${review.rating}</p>
                <p>Comment: ${review.comment}</p>
            </c:forEach>
        </td>
        <td>${product.detailedCharacteristics}</td>
    </tr>
</table><br>
</body>
</html>
