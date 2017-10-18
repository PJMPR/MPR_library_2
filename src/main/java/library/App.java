package library;

import library.dao.repositories.AdressRepository;
import library.dao.repositories.AuthorRepository;
import library.dao.repositories.PublisherRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AuthorRepository authorRepository = new AuthorRepository();
    	authorRepository.createTable();
    	
    	AdressRepository adressRepository = new AdressRepository();
    	adressRepository.createtable();
    	
    	PublisherRepository publisherRepository = new PublisherRepository();
    	publisherRepository.createTable();
    	
        System.out.println( "Koniec" );
    }
}
