package library.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import library.domain.Book;

public class BookMapper implements IMapper<Book> {

	public Book map(ResultSet rs) throws SQLException {
		return new Book();
	}

}
