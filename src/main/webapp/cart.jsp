<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="library.domain.ReservationOrder"%>
<%@page import="library.domain.Book"%>
<%@page import="library.web.SessionNames" %>
<%@page import="library.dao.repositories.IDatabaseCatalog"%>
<%@page import="library.dao.repositories.impl.HsqlCatalogFactory"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<% 
		Book book = new Book();
		book.setTitle("tytul");
		ReservationOrder ro1 = new ReservationOrder();
		ReservationOrder ro2 = new ReservationOrder();
		ReservationOrder ro3 = new ReservationOrder();
		ro1.setBook(book);
		ro2.setBook(book);
		ro3.setBook(book);
		
		ArrayList<ReservationOrder> listOfReservationOrders = new ArrayList<ReservationOrder>();
		listOfReservationOrders.add(ro1);
		listOfReservationOrders.add(ro2);
		listOfReservationOrders.add(ro3);
	
		
		IDatabaseCatalog library = new HsqlCatalogFactory().library();
		session.setAttribute(SessionNames.OrderedBookList, listOfReservationOrders);
		int deletedReservationOrderId = -1;
		boolean saveAll = false;
		
		for(ReservationOrder o : listOfReservationOrders){%>		
			<%=o.getBook().getTitle()%> <a href =/CartItemDeleteServlet?bookId=<%=o.getBook().getId() %> > usuń to</a><br>
		<% } %>

		<%session.setAttribute("deletedItemId", deletedReservationOrderId);%>;
		<br><button type="submit" action=/CartServlet%>>Zatwierdzam</button>

		
	
</body>
</html>