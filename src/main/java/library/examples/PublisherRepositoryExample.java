package library.examples;

import java.sql.Connection;
import java.util.List;

import library.dao.mappers.PublisherMapper;
import library.dao.repositories.PublisherRepository;
import library.domain.Author;
import library.domain.Publisher;

public class PublisherRepositoryExample {
	
	public static void execute(Connection connection){

    	PublisherRepository publisherRepository = new PublisherRepository(connection, new PublisherMapper());
    	publisherRepository.createTable();
    	Publisher publisher = new Publisher("Maciek", 1928301723, "maciekwiat@onet.pl",  "maciekwiat.org");
    	publisherRepository.add(publisher);
    	publisherRepository.add(publisher);
    	publisherRepository.add(publisher);

    	System.out.println("Count: "+publisherRepository.count());
    	System.out.println("last id: "+publisherRepository.lastId());
    	
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
