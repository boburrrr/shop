<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: davla
  Date: 5/7/2023
  Time: 10:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
    <h1>Admin</h1>
    <h3>Your balance ${user.hisob.balance} $</h3>

    <form action="/admin/create-product" method="get">
        <input type="hidden" value="${user.id}" name="userId">
        <button>Create Product</button>
    </form>
    <a href="/"><button>Log Out</button></a>

    <table>
        <thead>
        <th> Name</th>
        <th> Price</th>
        <th> R/P</th>
        <th> Create Date</th>
        <th> Method 1</th>
        <th> Method 2</th>
        </thead>
        <tbody>
        <jsp:useBean id="products" scope="request" type="java.util.List"/>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.recurrence_period}</td>
                <td>${product.create_date}</td>
                <td>
                    <form action="/admin/update" method="get">
                        <input type="hidden" name="userId" value="${user.id}">
                        <input type="hidden" name="productId" value="${product.id}">
                        <button>Update</button>
                    </form>
                </td>
                <td>
                    <form action="/admin/delete" method="post">
                        <input type="hidden" name="productId" value="${product.id}">
                        <input type="hidden" name="userId" value="${user.id}">
                        <button>Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
