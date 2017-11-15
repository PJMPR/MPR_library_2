package library.dao.repositories;

import java.sql.SQLException;

import library.domain.Author;

public interface IDatabaseCatalog {
	public IAuthorRepository authors();
	public IPublisherRepository publishers() throws SQLException;
	public INotificationRepository notifications() throws SQLException;
	public IAuthorRepository authors()
	public IUserRepository users() throws SQLException   ;
	
	public IAdressRepository addresses();
	
}
