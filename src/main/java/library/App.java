package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import library.dao.repositories.IDatabaseCatalog;
import library.dao.repositories.impl.DatabaseCatalog;
import library.dao.uow.IUnitOfWork;
import library.dao.uow.UnitOfWork;
import library.examples.*;

public class App
{
    public static void main( String[] args ) throws SQLException
    {
    	Connection connection 
    		= DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
    	IUnitOfWork uow = new UnitOfWork(connection);
			IDatabaseCatalog catalog = new DatabaseCatalog(connection, uow);
	    	AuthorRepositoryExample.execute(connection, catalog);
	    	//AddressRepositoryExample.execute(connection, catalog);
	    	//UserRepositoryExample.execute(connection, catalog);
	    	NotificationRepositoryExample.execute(connection, catalog);
	    	//PublisherRepositoryExample.execute(connection, catalog);
			//BookInformationRepositoryExample.execute(connection, catalog);
	    	
			uow.saveChanges();
    	connection.close();
    	
        System.out.println( "Koniec" );
    }
}
