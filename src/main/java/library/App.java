package library;

import library.examples.AdressRepositoryExample;
import library.examples.AuthorRepositoryExample;
import library.examples.PublisherRepositoryExample;
public class App 
{
    public static void main( String[] args )
    {
    	
    	AuthorRepositoryExample.execute();
    	AdressRepositoryExample.execute();
    	PublisherRepositoryExample.execute();
    	
        System.out.println( "Koniec" );
    }
}
