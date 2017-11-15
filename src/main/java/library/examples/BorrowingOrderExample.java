package library.examples;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import library.dao.repositories.IDatabaseCatalog;
import library.domain.BorrowingOrder;
import library.domain.User;
import library.domain.Book;

public class BorrowingOrderExample {


public static void execute(Connection connection, IDatabaseCatalog catalog){
	
	@SuppressWarnings("deprecation")
	Date dateFrom = new Date(03, 03, 1993);
	
	@SuppressWarnings("deprecation")
	Date dateFrom2 = new Date(03, 04, 1993);
	
	@SuppressWarnings("deprecation")
	Date dateTo = new Date(04, 03, 1993);
	
	User user = new User();
	
	Book book = new Book();
	
	

	catalog.borrowingOrders().createTable();
	BorrowingOrder borrowingOrder = new BorrowingOrder(user, book, dateFrom, dateTo);
	catalog.borrowingOrders().add(borrowingOrder);
	catalog.borrowingOrders().add(borrowingOrder);
	catalog.borrowingOrders().add(borrowingOrder);

	System.out.println("Count: "+catalog.borrowingOrders().count());
	System.out.println("last id: "+catalog.borrowingOrders().lastId());
	
	List<BorrowingOrder> borrowingOrdersWithId5 = catalog.borrowingOrders().withId(5);
	
	List<BorrowingOrder> borrowingOrders = catalog.borrowingOrders().getPage(1, 2);
	
	for(BorrowingOrder a: borrowingOrders){
		System.out.println(a.getId());
	}
	
	BorrowingOrder toDelete = borrowingOrders.get(0);
	catalog.borrowingOrders().delete(toDelete);
	
	BorrowingOrder updateDateFrom = borrowingOrders.get(3);
	updateDateFrom.setDateFrom(dateFrom2);
	
	catalog.borrowingOrders().update(updateDateFrom);
	
}

}
