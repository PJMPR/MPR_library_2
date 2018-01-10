package library.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import library.domain.User;

public class UserMapper implements IMapper<User>{

	public User map(ResultSet rs) throws SQLException {
		User a = new User();
		a.setId(rs.getInt("id"));
		a.setLogin(rs.getString("login"));
		a.setPassword(rs.getString("password"));
		a.setStatus(rs.getBoolean("status"));
		a.setAdmin(rs.getBoolean("admin"));
		return a;
	}

}
