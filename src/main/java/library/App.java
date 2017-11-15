package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import library.dao.repositories.IDatabaseCatalog;
import library.dao.repositories.impl.DatabaseCatalog;
import library.examples.*;

public class App
{
    public static void main( String[] args ) throws SQLException
    {
    	Connection connection 
    		= DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
			IDatabaseCatalog catalog = new DatabaseCatalog(connection);
	    	AuthorRepositoryExample.execute(connection, catalog);
	    	AddressRepositoryExample.execute(connection);
	    	UserRepositoryExample.execute(connection);
	    	PublisherRepositoryExample.execute(connection);
			BookInformationRepositoryExample.execute(connection);
	    	
    	connection.close();
    	
        System.out.println( "Koniec" );
    }
}
