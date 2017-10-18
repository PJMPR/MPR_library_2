package library;

import library.dao.repositories.AuthorRepository;

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
    	
        System.out.println( "Koniec" );
    }
}
