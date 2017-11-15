package library.dao.repositories.impl;

import java.sql.Connection;

import library.dao.mappers.AuthorMapper;
import library.dao.mappers.UserMapper;
import library.dao.repositories.IAuthorRepository;
import library.dao.repositories.IDatabaseCatalog;
import library.dao.repositories.IRepository;
import library.dao.repositories.IUserRepository;
import library.domain.Author;

public class DatabaseCatalog implements IDatabaseCatalog{

	
	private Connection connection;
	public DatabaseCatalog(Connection connection){
		this.connection = connection;
	}
	
	public IAuthorRepository authors() {
		return new AuthorRepository(connection, new AuthorMapper());
	}

	public IUserRepository users() {
		return new UserRepository(connection, new UserMapper());
	}

}
