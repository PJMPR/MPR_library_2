package library.domain;

import java.util.Date;

public class ReservationOrder {

	private BookInformation bookInformation;
	public void setBookInformation(BookInformation bookInformation) {
		this.bookInformation = bookInformation;
	}

	private User user;
	private Date date;

	public BookInformation getBookInformation() {
		return bookInformation;
	}

	public User getUser() {
		return user;
	}

	public Date getDate() {
		return date;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
