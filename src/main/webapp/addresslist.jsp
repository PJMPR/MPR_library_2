<%@page import="library.domain.Address"%>
<%@page import="library.dao.repositories.impl.HsqlCatalogFactory"%>
<%@page import="library.dao.repositories.IDatabaseCatalog"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Address List</title>
</head>
<body>

	<form method="get" action="addresslist.jsp?pg=">
	<table border= 2px>
	<tr><th>User</th><th>Street</th><th>City</th></tr>
	<% 
	
		IDatabaseCatalog library = new HsqlCatalogFactory().library();
		int pg;
		int pgs = library.addresses().count()/5;
		if(request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}
		else pg = 1;
	
		
		for(Address a : library.addresses().getPage(pg, 5)){
			%>
			<tr>
			<th><%=a.getUserId() %></th><th><%=a.getStreet()%> <%=a.getApNumber() %></th>
			<th><%=a.getCity() %></th>
			</tr>
		<% }%>
			</table>	
			<button type="submit" value  = <%=pg-1 %> name="pg">prev</button>
			<button type="submit" value=<%=pg+1%> name="pg";
			%>>next</button>
			</form>
			
			
</body>
</html>
