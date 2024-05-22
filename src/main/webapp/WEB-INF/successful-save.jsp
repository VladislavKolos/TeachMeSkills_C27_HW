<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22.05.2024
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>

<head>
    <title>Successful saving of user application</title>
</head>

<body>
<h1>Application successfully saved</h1>
<p>Email: <c:out value="${email}"/></p>
<p>Nickname: <c:out value="${nickName}"/></p>
<p>Message text: <c:out value="${messageText}"/></p>
</body>

</html>
