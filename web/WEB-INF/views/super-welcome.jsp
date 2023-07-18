<%--
  Created by IntelliJ IDEA.
  User: davla
  Date: 5/8/2023
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Super Admin</title>
</head>
<body>
  <h1>Super Admin</h1>
  <h3>Your balance ${user.hisob.balance} $</h3>
    <a href="/super/user-controller"><button>User Controller</button></a>
    <a href="/super/admin-controller"><button>Admin Controller</button></a>
    <a href="/"><button>Log Out</button></a>
</body>
</html>
