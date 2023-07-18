<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: davla
  Date: 5/7/2023
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
    <h1>User</h1>
    <form action="/user/card" method="get">
        <input type="hidden" name="userId", value="${user.id}">
        <button>CRUD Card</button>
    </form>
    <form action="/user/order" method="get">
        <input type="hidden" name="userId", value="${user.id}">
        <button>My Order</button>
    </form>
    <a href="/"><button>Log Out</button></a>

    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Price</th>
                <th>R/P</th>
                <th>Create Date</th>
                <th>Method</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.recurrence_period}</td>
                    <td>${product.create_date}</td>
                    <td>
                        <form action="/user/buy" method="get">
                            <input type="hidden" name="userId" value="${user.id}">
                            <input type="hidden" name="productId" value="${product.id}">
                            <button>Buy</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
