<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="PublisherServlet">
		<label>name:<input type="text" id="name" name="name"></label>
		<br/>
		<label>phone number:<input type="text" id="phoneNumber" name="phoneNumber"></label>
		<br/>
		<label>email:<input type="text" id="email" name="email"></label>
		<br/>
		<label>website:<input type="text" id="website" name="website"></label>
		<br/>
		<button type="submit">Send</button>
	</form>
</body>
</html>