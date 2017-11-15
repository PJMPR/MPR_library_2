package library.dao.repositories.impl;

import java.sql.Connection;
import java.sql.SQLException;

import library.dao.mappers.AuthorMapper;
import library.dao.mappers.BorrowingOrderMapper;
import library.dao.mappers.ReservationOrderMapper;
import library.dao.mappers.NotificationMapper;
import library.dao.mappers.PublisherMapper;
import library.dao.mappers.UserMapper;
import library.dao.repositories.IAdressRepository;
import library.dao.repositories.IAuthorRepository;
import library.dao.repositories.IBorrowingOrderRepository;
import library.dao.repositories.IDatabaseCatalog;
import library.dao.repositories.IReservationOrderRepository;
import library.dao.repositories.INotificationRepository;
import library.dao.repositories.IPublisherRepository;
import library.dao.repositories.IRepository;
import library.dao.repositories.IUserRepository;
import library.dao.uow.IUnitOfWork;
import library.domain.Author;

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
		return new BorrowingOrderRepository(connection, new BorrowingOrderMapper());
	}
	
	public IReservationOrderRepository reservationOrders() throws SQLException {
		return new ReservationOrderRepository(connection, new ReservationOrderMapper());
	}
	public IPublisherRepository publishers() throws SQLException {
		return new PublisherRepository(connection, new PublisherMapper());
	}

	public INotificationRepository notifications() throws SQLException {
		return new NotificationRepository(connection, new NotificationMapper());
  }
  
	public IUserRepository users() {
		try {
			return new UserRepository(connection, new UserMapper());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public IAdressRepository addresses() {
		// TODO Auto-generated method stub
		return null;
	}

}
