package library.dao.repositories;


public interface IDatabaseCatalog {

	public IAuthorRepository authors();
	public IBorrowingOrderRepository borrowingOrders();
	public IReservationOrderRepository reservationOrders();
	
}
