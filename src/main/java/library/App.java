package library;

import library.dao.repositories.AdressRepository;
import library.dao.repositories.AuthorRepository;
import library.dao.repositories.BookInformationRepository;
import library.dao.repositories.BookRepository;
import library.dao.repositories.PublisherRepository;
import library.dao.repositories.BorrowingOrderRepository;
import library.dao.repositories.NotificationRepository;
import library.dao.repositories.ReservationOrderRepository;
import library.domain.Adress;
import library.domain.Author;
import library.domain.Book;
import library.domain.BookInformation;
import library.domain.Publisher;
import library.domain.Section;
import library.dao.repositories.*;
import library.domain.*;
import library.examples.AdressRepositoryExample;
import library.examples.AuthorRepositoryExample;
public class App 
{
    public static void main( String[] args )
    {
    	
    	AuthorRepositoryExample.execute();
    	AdressRepositoryExample.execute();
    	
        System.out.println( "Koniec" );
    }
}
