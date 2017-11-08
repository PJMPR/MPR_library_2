package library.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import library.domain.ReservationOrder;

public class ReservationOrderMapper implements IMapper<ReservationOrder>{
	
	public ReservationOrder map(ResultSet rs) throws SQLException {
		ReservationOrder a = new ReservationOrder();
		a.setId(rs.getInt("id"));
		a.setUserId(rs.getInt("userId"));
		a.setDate(rs.getDate("date"));
		return a;
	}
}
