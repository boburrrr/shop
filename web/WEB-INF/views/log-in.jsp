<%--
  Created by IntelliJ IDEA.
  User: davla
  Date: 5/7/2023
  Time: 9:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        Log In
    </title>
</head>
<body>
    <h1>Log In</h1>
    <form action="/log-in" method="post">
        <input name="tel_number" type="text" placeholder="tel number"/>
        <input name="password" type="password" placeholder="password"/>
        <button>Enter</button>
    </form>

    <div>
        <c:if test="${message != null}">${message}</c:if>
    </div>
</body>
</html>
