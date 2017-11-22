package library.dao.repositories;

import java.sql.SQLException;

import library.domain.Author;
import library.domain.Book;

public interface IDatabaseCatalog {
	public IAuthorRepository authors();
	public IBorrowingOrderRepository borrowingOrders() throws SQLException;
	public IReservationOrderRepository reservationOrders() throws SQLException;
	public IPublisherRepository publishers();
	public INotificationRepository notifications() throws SQLException;
	public IRepository<Book> books() throws SQLException;
	public IUserRepository users();
	
	public IAdressRepository addresses();
	
	public void saveChanges();
	
}
