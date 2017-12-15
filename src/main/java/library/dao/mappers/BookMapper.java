package library.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import library.dao.repositories.impl.HsqlCatalogFactory;
import library.domain.Book;

public class BookMapper implements IMapper<Book> {

	public Book map(ResultSet rs) throws SQLException {
		Book a = new Book();
		a.setId(rs.getInt("id"));
		a.setLanguage(rs.getString("language"));
		a.setTitle(rs.getString("title"));
		a.setAvailable(rs.getString("isAvailable").equalsIgnoreCase("y"));
		a.setAuthor(new HsqlCatalogFactory().library().authors().get(rs.getInt("authorId")));
		a.setPublisher(new HsqlCatalogFactory().library().publishers().get(rs.getInt("publisherId")));
		return a;
		
	}

}
