<%--
  Created by IntelliJ IDEA.
  User: davla
  Date: 5/12/2023
  Time: 10:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Card</title>
</head>
<body>
    <h1>Create Card</h1>

    <form action="/card/create" method="post">
        <select name="type">
            <option value="HUMO">HUMO</option>
            <option value="UZCARD">UZCARD</option>
            <option value="VISA">VISA</option>
        </select>
        <input type="text" name="card_number" placeholder="card number">
        <input type="text" name="valid_thru" placeholder="valid thru">
        <input type="text" name="password" placeholder="password">
        <input type="number" name="balance" placeholder="balance">
        <input type="hidden" name="userId" value="${user.id}">
        <button>Submit</button>
    </form>
</body>
</html>
