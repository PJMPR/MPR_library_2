package library.dao.repositories.impl;

import java.sql.Connection;
import java.sql.SQLException;

import library.dao.mappers.AuthorMapper;
import library.dao.mappers.NotificationMapper;
import library.dao.mappers.PublisherMapper;
import library.dao.repositories.IAuthorRepository;
import library.dao.repositories.IDatabaseCatalog;
import library.dao.repositories.INotificationRepository;
import library.dao.repositories.IPublisherRepository;
import library.dao.repositories.IRepository;
import library.domain.Author;

public class DatabaseCatalog implements IDatabaseCatalog{

	
	private Connection connection;
	public DatabaseCatalog(Connection connection){
		this.connection = connection;
	}
	
	public IAuthorRepository authors() {
		return new AuthorRepository(connection, new AuthorMapper());
	}

	public IPublisherRepository publishers() throws SQLException {
		return new PublisherRepository(connection, new PublisherMapper());
	}

	public INotificationRepository notifications() throws SQLException {
		return new NotificationRepository(connection, new NotificationMapper());
	}

}
