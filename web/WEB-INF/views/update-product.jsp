<%--
  Created by IntelliJ IDEA.
  User: davla
  Date: 5/10/2023
  Time: 5:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Product</title>
</head>
<body>
    <h1>Update Product</h1>
    <h3>${product.name}  ${product.price}  ${product.recurrence_period}</h3>

    <form action="/admin/update" method="post">
        <input type="text" name="name" placeholder="name">
        <input type="number" name="price" placeholder="price">
        <input type="number" name="recurrence_period" placeholder="recurrence period">
        <input type="hidden" name="productId" value="${product.id}">
        <input type="hidden" name="userId" value="${product.user.id}">
        <button>Submit</button>
    </form>
</body>
</html>
