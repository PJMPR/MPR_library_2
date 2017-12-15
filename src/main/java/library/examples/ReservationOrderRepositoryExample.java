package library.examples;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import library.dao.repositories.IDatabaseCatalog;
import library.domain.Book;
import library.domain.ReservationOrder;
import library.domain.User;

public class ReservationOrderRepositoryExample {


public static void execute(Connection connection, IDatabaseCatalog catalog) throws SQLException{
	
	@SuppressWarnings("deprecation")
	Date date = new Date(03, 03, 1993);
	
	@SuppressWarnings("deprecation")
	Date date2 = new Date(03, 04, 1993);
	
	User user = new User();
	Book bookInformation = new Book();

	catalog.reservationOrders().createTable();
	ReservationOrder reservationOrder = new ReservationOrder(bookInformation, user, date);
	catalog.reservationOrders().add(reservationOrder);
	catalog.reservationOrders().add(reservationOrder);
	catalog.reservationOrders().add(reservationOrder);

	
}

}
