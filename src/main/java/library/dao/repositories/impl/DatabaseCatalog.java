package library.dao.repositories.impl;

import java.sql.Connection;
import java.sql.SQLException;

import library.dao.mappers.AdressMapper;
import library.dao.mappers.AuthorMapper;
import library.dao.mappers.BookMapper;
import library.dao.mappers.BorrowingOrderMapper;
import library.dao.mappers.ReservationOrderMapper;
import library.dao.mappers.NotificationMapper;
import library.dao.mappers.PublisherMapper;
import library.dao.mappers.UserMapper;
import library.dao.repositories.IAdressRepository;
import library.dao.repositories.IAuthorRepository;
import library.dao.repositories.IBookRepository;
import library.dao.repositories.IBorrowingOrderRepository;
import library.dao.repositories.IDatabaseCatalog;
import library.dao.repositories.IReservationOrderRepository;
import library.dao.repositories.INotificationRepository;
import library.dao.repositories.IPublisherRepository;
import library.dao.repositories.IRepository;
import library.dao.repositories.IUserRepository;
import library.dao.uow.IUnitOfWork;
import library.domain.Author;
import library.domain.Book;

public class DatabaseCatalog implements IDatabaseCatalog{

	
	private Connection connection;
	IUnitOfWork uow;
	public DatabaseCatalog(Connection connection, IUnitOfWork uow){
		this.connection = connection;
		this.uow = uow;
	}
	
	public IAuthorRepository authors() {
		try {
			return new AuthorRepository(connection, new AuthorMapper(), uow);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public IBorrowingOrderRepository borrowingOrders() throws SQLException {
		return new BorrowingOrderRepository(connection, new BorrowingOrderMapper(), uow);
	}
	
	public IReservationOrderRepository reservationOrders() throws SQLException {
		return new ReservationOrderRepository(connection, new ReservationOrderMapper(), uow);
	}
	public IPublisherRepository publishers() {
		try {
			return new PublisherRepository(connection, new PublisherMapper(), uow);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public INotificationRepository notifications(){
			try {
					return new NotificationRepository(connection, new NotificationMapper(), uow);
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
	}
 
  
	public IUserRepository users() {
		try {
			return new UserRepository(connection, new UserMapper(), uow);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public IAdressRepository addresses() {
		try {
			return new AddressRepository(connection, new AdressMapper(), uow);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void saveChanges() {
		uow.saveChanges();
		
	}

	public IBookRepository books() {
		try {
			return new BookRepository(connection, new BookMapper(), uow);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}

}
