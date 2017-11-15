package library.dao.repositories;

import java.sql.Date;
import java.util.List;

import library.domain.BorrowingOrder;

public interface IBorrowingOrderRepository extends IRepository<BorrowingOrder> {

	public List<BorrowingOrder> withId(int id);
	public List<BorrowingOrder> withDateFrom(Date dateFrom);
	public List<BorrowingOrder> withDateTo(Date dateTo);
}
