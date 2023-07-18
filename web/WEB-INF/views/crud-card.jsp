<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: davla
  Date: 5/11/2023
  Time: 11:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crud Card</title>
</head>
<body>
    <h1>Crud Card</h1>

    <form action="/card/create" method="get">
        <input type="hidden" name="userId" value="${user.id}">
        <button>Create Card</button>
    </form>

    <form action="/card/add-balance" method="get">
        <input type="hidden" name="userId" value="${user.id}">
        <button>Fill out the card</button>
    </form>

    <form action="/card/back" method="get">
        <input type="hidden" name="userId" value="${user.id}">
        <input type="hidden" name="path" value="${"user-welcome"}">
        <button>Back</button>
    </form>

    <table>
        <thead>
        <tr>
            <th>Type</th>
            <th>Card Number</th>
            <th>Valid Thru</th>
            <th>Balance</th>
            <th>Create Date</th>
            <th>Update</th>
            <th>Kill</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cards}" var="card">
            <tr>
                <td>${card.type}</td>
                <td>${card.card_number}</td>
                <td>${card.valid_thru}</td>
                <td>${card.balance}</td>
                <td>${card.create_date}</td>
                <td>
                    <form action="/card/update" method="get">
                        <input type="hidden" name="userId" value="${user.id}">
                        <input type="hidden" name="cardId" value="${card.id}">
                        <button>Update Password</button>
                    </form>
                </td>
                <td>
                    <form action="/card/delete" method="get">
                        <input type="hidden" name="userId" value="${user.id}">
                        <input type="hidden" name="cardId" value="${card.id}">
                        <button>✔</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
