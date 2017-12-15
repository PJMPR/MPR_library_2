package library.dao.repositories;

import java.util.List;

import library.domain.Author;

public interface IAuthorRepository extends IRepository<Author> {

	public List<Author> withName(String name);
	public List<Author> withSurname(String surname);
	public List<Author> selectAll();
	
}
