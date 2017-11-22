package library.examples;

import library.dao.repositories.IDatabaseCatalog;
import library.dao.repositories.IDatabaseCatalog;


import library.domain.Book;


import java.sql.Connection;

import java.util.List;

public class BookInformationRepositoryExample {

    public static void execute(Connection connection, IDatabaseCatalog catalog){

    	//Date date = new Date();
    	Book book = new Book();
    	book.setAvailable(true);
    	//book.setAdditionDate(2015-05-09);
    	//book.setReleaseDate();
    	book.setLanguage("polski");
    	book.setTitle("Karolajn");
    	
    	catalog.books().add(book);
    	catalog.books().add(book);
    	catalog.books().add(book);

    	System.out.println("Count: "+catalog.books().count());
    	System.out.println("last id: "+catalog.books().lastId());
    
    	List<Book> bookWithLanguagePolish = catalog.books().withLanguage("polski");
    	List<Book> bookWithTitleKarol = catalog.books().withTitle("karol");
    	List<Book> bookisAvailable = catalog.books().withAvailability(true);
    	List<Book> books = catalog.books().getPage(1, 2);

    	for(Book a: books){
    		System.out.println(a.getId());
    	}
    	catalog.saveChanges();
    	
    	Book toDelete = books.get(0);
    	catalog.books().delete(toDelete);
    	
    	catalog.saveChanges();
    	
    	Book updateTitle = books.get(1);
    	updateTitle.setTitle("kkk");
    	
    	catalog.books().update(updateTitle);
    	
	}
  
    
}
