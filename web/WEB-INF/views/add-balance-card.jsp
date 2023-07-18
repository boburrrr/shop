<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: davla
  Date: 5/15/2023
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Balance Card</title>
</head>
<body>
  <h>Add Balance Card</h>

  <form action="/card/add-balance" method="post">
    <select name="cardId">
      <c:forEach items="${cards}" var="card">
        <option value="${card.id}">${card.card_number} => ${card.balance} $</option>
      </c:forEach>
    </select>
    <input type="number" name="balance" placeholder="add balance">
    <input type="hidden" name="userId" value="${user.id}">
    <button>Add</button>
  </form>
</body>
</html>
