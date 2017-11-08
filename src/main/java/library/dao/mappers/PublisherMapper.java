package library.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import library.domain.Publisher;

public class PublisherMapper implements IMapper<Publisher>{
	
	public Publisher map(ResultSet rs) throws SQLException {
		Publisher a = new Publisher();
		a.setId(rs.getInt("id"));
		a.setName(rs.getString("name"));
		a.setPhoneNumber(rs.getInt("phoneNumber"));
		a.setEmailAdress(rs.getString("emailAdress"));
		a.setWebsite(rs.getString("website"));
		return a;
	}
}
