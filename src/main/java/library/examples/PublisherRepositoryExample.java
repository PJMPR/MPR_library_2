package library.examples;

import java.util.List;

import library.dao.repositories.PublisherRepository;
import library.domain.Publisher;

public class PublisherRepositoryExample {
	
	public static void execute(){

    	PublisherRepository publisherRepository = new PublisherRepository();
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
		
	}
	
}
