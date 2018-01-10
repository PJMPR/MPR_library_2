<%@ page import="library.domain.Publisher" %>
<%@ page import="library.domain.Author" %>
<%@ page import="library.dao.repositories.IDatabaseCatalog" %>
<%@ page import="library.dao.repositories.impl.HsqlCatalogFactory" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="BookServlet">
    Title:
    <input type="text" name="Title">
    <br>
    Language:
    <input type="text" name="Language">
    <br>
    Availability:
    <input type="checkbox" name="Availability">
    <br>
    Publisher:
    <select name="Publisher">
    <%IDatabaseCatalog library = new HsqlCatalogFactory().library();
    	for(Publisher p: library.publishers().selectAll()){
    %>
    <option value=<%=p.getId() %>><%=p.getName() %></option>
    <%} %>
    </select>
   
    <br>
    Section:
    <input type="text" name="Section">
    <br>
    Author:
    <select name="Author">
    <%for(Author a: library.authors().selectAll()){%>
    <option value=<%=a.getId() %>><%=a.getName() %></option>
    <%} %>
    </select>
    <br>
    <button type="submit">SUBMIT</button>
</form>
</body>
</html>