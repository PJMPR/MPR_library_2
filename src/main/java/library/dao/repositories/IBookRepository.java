package library.dao.repositories;

import java.util.Date;
import java.util.List;

import library.domain.Book;

public interface IBookRepository extends IRepository<Book>{
	
	public List<Book> withLanguage(String language);
	public List<Book> withTitle(String title);
	public List<Book> withAdditionDate(Date additionDate);
	public List<Book> withReleaseDate(Date releaseDate);
	public List<Book> withAvailability(Boolean isAvaialble );
	public List<Book> selectAll();

}
