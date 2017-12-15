package library.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import library.dao.repositories.impl.HsqlCatalogFactory;
import library.domain.ReservationOrder;

public class ReservationOrderMapper implements IMapper<ReservationOrder>{
	
	public ReservationOrder map(ResultSet rs) throws SQLException {
		ReservationOrder a = new ReservationOrder();
		a.setId(rs.getInt("id"));
		a.setUser(new HsqlCatalogFactory().library().users().get(rs.getInt("userId")));
		a.setBook(new HsqlCatalogFactory().library().books().get(rs.getInt("bookId")));
		a.setDate(rs.getDate("date"));
		return a;
	}
}
