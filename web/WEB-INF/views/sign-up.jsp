<%--
  Created by IntelliJ IDEA.
  User: davla
  Date: 5/7/2023
  Time: 9:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
    <h1>Sign Up</h1>
    <form action="/sign-up" method="post">
        <input name="name" type="text" placeholder="name"/>
        <input name="tel_number" type="text" placeholder="tel number"/>
        <input name="password" type="text" placeholder="password"/>
        <button>Submit</button>
    </form>
</body>
</html>
