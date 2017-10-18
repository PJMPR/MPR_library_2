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
import library.domain.Publisher;
public class App 
{
    public static void main( String[] args )
    {
    	AuthorRepository authorRepository = new AuthorRepository();
    	authorRepository.createTable();
    	Author author = new Author("Jan", "Maciej", "Kowalski");
    	authorRepository.add(author);
    	
    	
    	AdressRepository adressRepository = new AdressRepository();
    	adressRepository.createtable();
    	Adress adress = new Adress("Gdansk", "32-456", "Grunwaldzka", "121");
    	adressRepository.add(adress);
    	
    	PublisherRepository publisherRepository = new PublisherRepository();
    	publisherRepository.createTable();
    	Publisher publisher = new Publisher();
    	publisher.setName("Vadenecum");
    	publisher.setEmailAdress("vadenecum@gmail.com");
    	publisher.setPhoneNumber(123456789);
    	publisher.setWebsite("vadenecum.com");
    	publisherRepository.add(publisher);
    	
    	NotificationRepository notificationRepository = new NotificationRepository();
    	notificationRepository.createTable();
    	
    	BorrowingOrderRepository borrowingOrderRepository = new BorrowingOrderRepository();
    	borrowingOrderRepository.createTable();
    	
    	ReservationOrderRepository reservationOrderRepository = new ReservationOrderRepository();
    	reservationOrderRepository.createTable();
    	
    	BookInformationRepository bookInformationRepository = new BookInformationRepository();
    	bookInformationRepository.createTable();
    	
    	BookRepository bookRepository = new BookRepository();
    	bookRepository.createTable();
    	
        System.out.println( "Koniec" );
    }
}
