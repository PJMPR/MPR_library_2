<%@page import="library.domain.Notification"%>
<%@page import="library.dao.repositories.impl.HsqlCatalogFactory"%>
<%@page import="library.dao.repositories.IDatabaseCatalog"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Notification details</title>
</head>
<body>
<ul>
	<% 
		IDatabaseCatalog library = new HsqlCatalogFactory().library(); 
		int id = Integer.parseInt(request.getParameter("id"));
		Notification n = library.notifications().get(id); %>
		<%= n.getId()%><br>
		<%= n.getMessage()%><br>
		<%= n.getNotification_type()%><br>
		<%= n.getUser()	%><br>
</ul>
	
</body>
</html>