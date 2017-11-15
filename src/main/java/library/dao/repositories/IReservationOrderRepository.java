package library.dao.repositories;

import java.sql.Date;
import java.util.List;

import library.domain.ReservationOrder;

public interface IReservationOrderRepository extends IRepository<ReservationOrder> {

	public ReservationOrder withId(int id);
	public List<ReservationOrder> withDate(Date date);

}
