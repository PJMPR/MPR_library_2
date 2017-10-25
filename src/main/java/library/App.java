package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import library.examples.*;

public class App
{
    public static void main( String[] args )
    {
    	try(Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb")) {
			
	    	AuthorRepositoryExample.execute(connection);
	    	AdressRepositoryExample.execute(connection);
	    	UserRepositoryExample.execute(connection);
	    	PublisherRepositoryExample.execute();
			BookInformationRepositoryExample.execute();
	    	
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
        System.out.println( "Koniec" );
    }
}
