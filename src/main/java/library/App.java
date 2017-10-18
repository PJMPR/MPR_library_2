package library;

import library.dao.repositories.AdressRepository;
import library.dao.repositories.AuthorRepository;
import library.dao.repositories.PublisherRepository;
import library.dao.repositories.BorrowingOrderRepository;
import library.dao.repositories.NotificationRepository;
import library.dao.repositories.ReservationOrderRepository;
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
    	
    	NotificationRepository notificationRepository = new NotificationRepository();
    	notificationRepository.createTable();
    	
    	BorrowingOrderRepository borrowingOrderRepository = new BorrowingOrderRepository();
    	borrowingOrderRepository.createTable();
    	
    	ReservationOrderRepository reservationOrderRepository = new ReservationOrderRepository();
    	reservationOrderRepository.createTable();
    	
        System.out.println( "Koniec" );
    }
}
