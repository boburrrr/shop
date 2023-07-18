<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: davla
  Date: 5/8/2023
  Time: 5:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Controller</title>
</head>
<body>
  <h1>Admin Controller</h1>

  <form action="/super/back" method="get">
      <input type="hidden" name="path" value="${"super-welcome"}">
      <button>Back</button>
  </form>

  <table>
      <thead>
      <th> Name</th>
      <th> Number</th>
      <th> Created Date</th>
      <th> Update Date</th>
      <th> Method</th>
      <th> Blocked</th>
      </thead>
      <tbody>
      <c:forEach items="${users}" var="user">
          <tr>
              <td>${user.name}</td>
              <td>${user.tel_number}</td>
              <td>${user.create_date}</td>
              <td>${user.update_date}</td>
              <td>
                  <form action="/super/admin-controller" method="post">
                      <input type="hidden" name="userId" value="${user.id}">
                      <button>Go User</button>
                  </form>
              </td>
              <td>
                  <form action="/super/admin-blocked" method="post">
                      <input type="hidden" name="userId" value="${user.id}">
                      <button>Blocked</button>
                  </form>
              </td>
          </tr>
      </c:forEach>
      </tbody>
  </table>
</body>
</html>
