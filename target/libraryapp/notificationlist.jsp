<%@page import="library.domain.Notification"%>
<%@page import="library.dao.repositories.impl.HsqlCatalogFactory"%>
<%@page import="library.dao.repositories.IDatabaseCatalog"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Notification list</title>
</head>
<body>
<ul>
	<% 
		IDatabaseCatalog library = new HsqlCatalogFactory().library();
		int pg;
		int pgs = library.notifications().count()/10;
		if(request.getParameter("pg") != null){
			pg = Integer.parseInt(request.getParameter("pg"));
		} else {
			pg = 1;
		}
		
		for(Notification n : library.notifications().getPage(pg, 10)){%>		
			<li><a href="notificationdetails.jsp?id=<%=n.getId() %>"><%=n.getId()%> <%= n.getNotification_type() %></a></li>
		<% } %>
</ul>
<form action="notificationlist.jsp" method="GET">
<% if(pg>1){ %>
<button type="submit" value=<%= pg-1 %> name="pg">Prev</button>
<% } %>
<% if(pg<=pgs){ %>
<button type="submit" value=<%= pg+1 %> name="pg">Next</button>
<% } %>
</form>
</body>
</html>
