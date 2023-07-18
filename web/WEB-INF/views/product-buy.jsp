<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: davla
  Date: 5/10/2023
  Time: 10:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Buy</title>
</head>
<body>
    <h1>Product Buy</h1>

    <form action="/user/buy" method="post">
        <input type="number" name="number" placeholder="Product number">
        <input type="hidden" name="full_price" value="${product.price}">
        <input type="hidden" name="userId" value="${user.id}">
        <input type="hidden" name="productId" value="${product.id}">
        <button>Submit</button>
    </form>
</body>
</html>
