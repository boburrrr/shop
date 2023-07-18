<%--
  Created by IntelliJ IDEA.
  User: davla
  Date: 5/10/2023
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
</head>
<body>
  <h1>Create Product</h1>

  <form action="/admin/create-product" method="post">
      <input type="text" name="name" placeholder="name">
      <input type="number" name="price" placeholder="price">
      <input type="number" name="recurrence_period" placeholder="recurrence period">
      <input type="hidden" name="userId" value="${user.id}">
      <button>Submit</button>
  </form>
</body>
</html>
