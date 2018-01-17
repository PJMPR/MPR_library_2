<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Adress</title>
</head>
<body>

<h1>Adress Form</h1>
<form action="AdressServlet">
    City:
    <input type="text" name="city">
    <br>
    Postal code:
    <input type="text" name="postal">
    <br>
    Street:
    <input type="text" name="street">
    <br>
    Ap Number:
    <input type="text" name="apnumber">
    <br>
    <button type="submit">SUBMIT</button>
</form>
<br>
<a href="index.html">Return to main page</a>

</body>
</html>