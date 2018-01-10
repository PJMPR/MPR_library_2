<%@ page import="library.domain.Book" %>
<%@ page import="library.dao.repositories.impl.HsqlCatalogFactory"  %>
<%@ page import="library.dao.repositories.IDatabaseCatalog" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
	<td>ID</td>
	<td>Title</td>
	<td>Author</td>
	<td>Publisher</td>
	<td>Language</td>
	<td>Availability</td>
	<td>Reservation</td>
</tr>
<% 	IDatabaseCatalog library = new HsqlCatalogFactory().library();
	int pageNr = 1;
	if(request.getParameter("pageNr") != null && !request.getParameter("pageNr").isEmpty())
		pageNr = Integer.parseInt(request.getParameter("pageNr"));
	for(Book b: library.books().getPage(pageNr, 10)){
%>
<tr>
	<td><%=b.getId() %></td>
	<td><%=b.getTitle() %></td>
	<td><%=b.getAuthor().getName() + " " +b.getAuthor().getSurname() %></td>
	<td><%=b.getPublisher().getName() %></td>
	<td><%=b.getLanguage() %></td>
	<td><%=b.isAvailable() %></td>
	<td><a href="ReservationOrderServlet?userId=0&bookId=<%= b.getId() %>">Book</a></td>
</tr>
<%} %>
</table>
<%if(pageNr>1){ %>
<a href="BookList.jsp?pageNr=<%= pageNr-1 %>">Previous</a>
<br>
<%} %>
<%if(pageNr*10<library.books().count()+1) {%>
<a href="BookList.jsp?pageNr=<%= pageNr+1 %>">Next</a>
<%} %>
</body>
</html>