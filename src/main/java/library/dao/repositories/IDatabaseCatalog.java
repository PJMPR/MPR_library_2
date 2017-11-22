package library.dao.repositories;

import java.sql.SQLException;

import library.domain.Author;

public interface IDatabaseCatalog {
	public IAuthorRepository authors();
	public IBorrowingOrderRepository borrowingOrders() throws SQLException;
	public IReservationOrderRepository reservationOrders() throws SQLException;
	public IPublisherRepository publishers() throws SQLException;
	public INotificationRepository notifications() throws SQLException;

	public IUserRepository users();
	
	public IAdressRepository addresses();
	
	public void saveChanges();
	
}
