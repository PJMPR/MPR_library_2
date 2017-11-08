package library.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import library.domain.BorrowingOrder;

public class BorrowingOrderMapper {
	public BorrowingOrder map(ResultSet rs) throws SQLException {
		BorrowingOrder a = new BorrowingOrder();
		a.setId(rs.getInt("id"));
		a.setDateFrom(rs.getDate("dateFrom"));
		a.setDateTo(rs.getDate("dateTo"));
		return a;
	}
}
