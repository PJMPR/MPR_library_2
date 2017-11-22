package library.examples;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import library.dao.repositories.IDatabaseCatalog;
import library.domain.BookInformation;
import library.domain.ReservationOrder;
import library.domain.User;
import library.domain.Book;

public class ReservationOrderRepositoryExample {


public static void execute(Connection connection, IDatabaseCatalog catalog) throws SQLException{
	
	@SuppressWarnings("deprecation")
	Date date = new Date(03, 03, 1993);
	
	@SuppressWarnings("deprecation")
	Date date2 = new Date(03, 04, 1993);
	
	User user = new User();
	BookInformation bookInformation = new BookInformation();
	

	

	catalog.reservationOrders().createTable();
	ReservationOrder reservationOrder = new ReservationOrder(bookInformation, user, 8, date);
	catalog.reservationOrders().add(reservationOrder);
	catalog.reservationOrders().add(reservationOrder);
	catalog.reservationOrders().add(reservationOrder);

	System.out.println("Count: "+catalog.reservationOrders().count());
	System.out.println("last id: "+catalog.reservationOrders().lastId());
	
	//List<ReservationOrder> reservationOrdersWithId5 = catalog.reservationOrders().withId(5);
	
	List<ReservationOrder> reservationOrders = catalog.reservationOrders().getPage(1, 2);
	
	for(ReservationOrder a: reservationOrders){
		System.out.println(a.getId());
	}
	
	ReservationOrder toDelete = reservationOrders.get(0);
	catalog.reservationOrders().delete(toDelete);
	
	ReservationOrder updateDateFrom = reservationOrders.get(3);
	updateDateFrom.setDate(date2);
	
	catalog.reservationOrders().update(updateDateFrom);
	
}

}
