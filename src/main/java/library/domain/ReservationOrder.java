package library.domain;

import java.util.Date;

public class ReservationOrder {

	private BookInformation bookInformation;
	private User user;
	private Date date;


	public ReservationOrder(User user ,BookInformation bookInformation) {
		this.bookInformation = bookInformation;
		this.user = user;
		date = new Date();
	}
	
	public BookInformation getBookInformation() {
		return bookInformation;
	}

	public User getUser() {
		return user;
	}

	public Date getDate() {
		return date;
	}
}
