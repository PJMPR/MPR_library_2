<%--
  Created by IntelliJ IDEA.
  User: wasak
  Date: 13.12.17
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form action="LoginServlet" method="get">
    Nazwa:<br>
    <input type="text" name="nickname" placeholder="Nickname">
    <br>
    Haslo:<br>
    <input type="password" name="password" placeholder="Password">
    <br><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>
