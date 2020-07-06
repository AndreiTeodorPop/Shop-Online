<%--
  Created by IntelliJ IDEA.
  User: AndreiPop
  Date: 4/19/2020
  Time: 11:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error page</title>
</head>
<body>
<div align="center">
    <a href="http://localhost:9001/shop/homepage" >
        <img src="${pageContext.request.contextPath}/resources/Homepage.gif"
             width="150" height="50">
    </a>
</div><br>
<h2>Failed URL: ${url}</h2>
<h2>Exception: ${exception.message}</h2>
</body>
</html>
