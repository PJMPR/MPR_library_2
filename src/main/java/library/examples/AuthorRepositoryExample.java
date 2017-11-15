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

    	catalog.authors().createTable();
    	Author author = new Author("Jan", "Maciej", "Kowalski");
    	catalog.authors().add(author);
    	catalog.authors().add(author);
    	catalog.authors().add(author);

    	System.out.println("Count: "+catalog.authors().count());
    	System.out.println("last id: "+catalog.authors().lastId());
    	
    	List<Author> authorsWithNameJanek = catalog.authors().withName("jan");
    	
    	List<Author> authors = catalog.authors().getPage(1, 2);
    	
    	for(Author a: authors){
    		System.out.println(a.getId());
    	}
		
    	Author toDelete = authors.get(0);
    	catalog.authors().delete(toDelete);
    	
    	Author updateName = authors.get(1);
    	updateName.setName("Adam");
    	
    	catalog.authors().update(updateName);
    	
	}
	
}
