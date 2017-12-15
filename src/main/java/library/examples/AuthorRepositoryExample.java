package library.examples;

import java.sql.Connection;
import java.util.List;

import library.dao.mappers.AuthorMapper;
import library.dao.repositories.IDatabaseCatalog;
import library.dao.repositories.IRepository;
import library.dao.repositories.impl.AuthorRepository;
import library.domain.Author;

public class AuthorRepositoryExample {

	public static void execute(Connection connection, IDatabaseCatalog catalog){

    	Author author = new Author("Jan", "Maciej", "Kowalski");
    	catalog.authors().add(author);
    	catalog.authors().add(author);
    	catalog.authors().add(author);
    	catalog.saveChanges();
    	System.out.println("Count: "+catalog.authors().count());
    	System.out.println("last id: "+catalog.authors().lastId());
    	
    	List<Author> authorsWithNameJanek = catalog.authors().withName("jan");
    	
    	List<Author> authors = catalog.authors().getPage(1, 2);
    	
    	for(Author a: authors){
    		System.out.println(a.getId());
    	}
		catalog.saveChanges();
		
    	Author toDelete = authors.get(0);
    	catalog.authors().delete(toDelete);
    	
    	catalog.saveChanges();
    	
    	Author updateName = authors.get(1);
    	updateName.setName("Adam");
    	
    	catalog.authors().update(updateName);
    	
	}
	
}
