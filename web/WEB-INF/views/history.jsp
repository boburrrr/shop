<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: davla
  Date: 5/12/2023
  Time: 7:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History</title>
</head>
<body>
    <h1>History</h1>

    <form action="/user/my-order-back" method="get">
        <input type="hidden" name="userId" value="${user.id}">
        <input type="hidden" name="path" value="${"user-welcome"}">
        <button>Back</button>
    </form>

    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Full Price</th>
            <th>P Number</th>
            <th>Create Date</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${orders}" var="order">
            <tr>
                <td>${order.product.name}</td>
                <td>${order.product.price}</td>
                <td>${order.full_price}</td>
                <td>${order.number}</td>
                <td>${order.create_date}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
