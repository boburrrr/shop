<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: davla
  Date: 5/12/2023
  Time: 11:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>End Order</title>
</head>
<body>
    <h1>End Order</h1>

    <form action="/user/end-product-buy" method="get">
        <select name="buy_type">
            <c:forEach items="${cards}" var="card">
                <option value="${card.card_number}">${card.card_number} => ${card.balance} $</option>
            </c:forEach>
        </select>
        <input type="hidden" name="userId" value="${user.id}">
        <input type="hidden" name="orderId" value="${order.id}">
        <input type="hidden" name="productId" value="${order.product.id}">
        <button>Buy</button>
    </form>
</body>
</html>
