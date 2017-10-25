package library;

import library.examples.*;

public class App
{
    public static void main( String[] args )
    {
    	
    	AuthorRepositoryExample.execute();
    	UserRepositoryExample.execute();
    	AdressRepositoryExample.execute();
    	PublisherRepositoryExample.execute();
        BookInformationRepositoryExample.execute();
    	
        System.out.println( "Koniec" );
    }
}
