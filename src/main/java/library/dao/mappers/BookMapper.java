package library.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import library.domain.Author;
import library.domain.Book;

public class BookMapper implements IMapper<Book> {

	public Book map(ResultSet rs) throws SQLException {
		Book a = new Book();
		a.setId(rs.getInt("id"));
		a.setLanguage(rs.getString("language"));
		a.setTitle(rs.getString("title"));
		a.setReleaseDate(rs.getDate("releaseDate"));
		a.setAdditionDate(rs.getDate("additionDate"));
		a.setAvailable(rs.getString("isAvailable").equalsIgnoreCase("y"));
		return a;
		
	}

}
