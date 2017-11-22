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
	
	public static void execute(Connection connection, IDatabaseCatalog catalog) {

    	
    	Publisher publisher = new Publisher("Maciek", 1928301723, "maciekwiat@onet.pl",  "maciekwiat.org");
    	catalog.publishers().add(publisher);
    	catalog.publishers().add(publisher);
    	catalog.publishers().add(publisher);

    	System.out.println("Count: "+ catalog.publishers().count());
    	System.out.println("last id: "+ catalog.publishers().lastId());
    	
      	List<Publisher> publishersWithNameA = catalog.publishers().withName("A");
    	List<Publisher> publishers = catalog.publishers().getPage(1, 2);
    	
    	for(Publisher a: publishers){
    		System.out.println(a.getId());
    	}
    	catalog.saveChanges();
    	
    	Publisher toDelete = publishers.get(0);
    	catalog.publishers().delete(toDelete);
    	
    	catalog.saveChanges();
    	
    	Publisher updateName = publishers.get(1);
    	updateName.setName("Wilhelm");
    	
    	catalog.publishers().update(updateName);
    	
	}
	
}
