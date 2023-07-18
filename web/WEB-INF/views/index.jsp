<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Index</title>
</head>
<body>
    <h1>Home</h1>
    <a href="${pageContext.request.contextPath}/log-in">
        <button>Log In</button>
    </a>
    <a href="${pageContext.request.contextPath}/sign-up">
        <button>Sign up</button>
    </a>

    <div>
        <c:if test="${message != null}">${message}</c:if>
    </div>

</body>
</html>
