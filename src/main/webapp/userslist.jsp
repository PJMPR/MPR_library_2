<%@page import="library.domain.User"%>
<%@page import="library.dao.repositories.impl.HsqlCatalogFactory"%>
<%@page import="library.dao.repositories.IDatabaseCatalog"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
	<% 
		IDatabaseCatalog library = new HsqlCatalogFactory().library();
		for(User u : library.users().getPage(1, 10)){%>		
			<li><%=u.getLogin()%></li>
		<% } %>
</ul>
</body>
</html>
