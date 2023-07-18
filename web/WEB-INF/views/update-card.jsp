<%--
  Created by IntelliJ IDEA.
  User: davla
  Date: 5/15/2023
  Time: 1:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Card</title>
</head>
<body>
  <h1>Update Card</h1>

  <form action="/card/update" method="post">
    <input type="text" name="password" placeholder="Password">
    <input type="hidden" name="userId" value="${userId}">
    <input type="hidden" name="cardId" value="${cardId}">
    <button>Submit</button>
  </form>
</body>
</html>
