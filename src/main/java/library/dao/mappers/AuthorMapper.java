package library.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import library.domain.Author;

public class AuthorMapper implements IMapper<Author>{

	public Author map(ResultSet rs) throws SQLException {
		Author a = new Author();
		a.setId(rs.getInt("id"));
		a.setName(rs.getString("name"));
		a.setSecondName(rs.getString("secondname"));
		a.setSurname(rs.getString("surname"));
		return a;
	}

}
