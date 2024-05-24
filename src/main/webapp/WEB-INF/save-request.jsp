<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22.05.2024
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
    <title>Saving a user application</title>
</head>

<body>
<h1>Enter the data and save the application</h1>
<form action="${pageContext.request.contextPath}/save-request" method="post">
    <label for="email">Email:</label>
    <input type="email" name="email" id="email" value="${email}" required
           pattern="^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$"><br><br>
    <label for="nickName">Nickname:</label>
    <input type="text" id="nickName" name="nickName" value="${nickName}" required><br><br>
    <label for="messageText">Message text:</label><br>
    <textarea id="messageText" name="messageText" rows="5" cols="25" required></textarea><br><br>
    <button type="submit">Save application</button>
</form>
</body>

</html>
