package library.examples;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import library.dao.mappers.PublisherMapper;
import library.dao.repositories.IDatabaseCatalog;
import library.dao.repositories.IPublisherRepository;
import library.dao.repositories.impl.PublisherRepository;
import library.domain.Author;
import library.domain.Publisher;

public class PublisherRepositoryExample {
	
	public static void execute(Connection connection, IDatabaseCatalog catalog) throws SQLException{

    	IPublisherRepository publisherRepository = catalog.publishers();
    	publisherRepository.createTable();
    	Publisher publisher = new Publisher("Maciek", 1928301723, "maciekwiat@onet.pl",  "maciekwiat.org");
    	publisherRepository.add(publisher);
    	publisherRepository.add(publisher);
    	publisherRepository.add(publisher);

    	System.out.println("Count: "+ catalog.publishers().count());
    	System.out.println("last id: "+ catalog.publishers().lastId());
    	
      	List<Publisher> publishersWithNameA = catalog.publishers().withName("A");
    	List<Publisher> publishers = publisherRepository.getPage(1, 2);
    	
    	for(Publisher a: publishers){
    		System.out.println(a.getId());
    	}
		
    	Publisher toDelete = publishers.get(0);
    	publisherRepository.delete(toDelete);
    	
    	Publisher updateName = publishers.get(1);
    	updateName.setName("Wilhelm");
    	
    	publisherRepository.update(updateName);
    	
	}
	
}
