package library.dao.repositories.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import library.dao.repositories.IDatabaseCatalog;
import library.dao.repositories.IDbCatalogFactory;
import library.dao.uow.IUnitOfWork;
import library.dao.uow.UnitOfWork;

public class HsqlCatalogFactory implements IDbCatalogFactory{

	public IDatabaseCatalog library() {

    	try {
    		Class.forName("org.hsqldb.jdbcDriver");
			Connection connection 
				= DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
	    	IUnitOfWork uow = new UnitOfWork(connection);
				IDatabaseCatalog catalog = new DatabaseCatalog(connection, uow);
			return catalog;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return null;
	}

}
