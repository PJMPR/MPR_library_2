package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import library.examples.AdressRepositoryExample;
import library.examples.AuthorRepositoryExample;
import library.examples.UserRepositoryExample;
import library.examples.PublisherRepositoryExample;
public class App 
{
    public static void main( String[] args )
    {
    	try(Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb")) {
			
	    	AuthorRepositoryExample.execute(connection);
	    	UserRepositoryExample.execute();
	    	AdressRepositoryExample.execute(connection);
	    	PublisherRepositoryExample.execute();
	    	
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
        System.out.println( "Koniec" );
    }
}
