package library.examples;

import java.util.List;

import library.dao.repositories.AuthorRepository;
import library.domain.Author;

public class AuthorRepositoryExample {

	public static void execute(){

    	AuthorRepository authorRepository = new AuthorRepository();
    	authorRepository.createTable();
    	Author author = new Author("Jan", "Maciej", "Kowalski");
    	authorRepository.add(author);
    	authorRepository.add(author);
    	authorRepository.add(author);

    	System.out.println("Count: "+authorRepository.count());
    	System.out.println("last id: "+authorRepository.lastId());
    	
    	List<Author> authors = authorRepository.getPage(1, 2);
    	
    	for(Author a: authors){
    		System.out.println(a.getId());
    	}
		
    	Author toDelete = authors.get(0);
    	authorRepository.delete(toDelete);
    	
    	Author updateName = authors.get(1);
    	updateName.setName("Adam");
    	
    	authorRepository.update(updateName);
    	
	}
	
}
