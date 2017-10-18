package library.domain;

import java.time.LocalDate;

public class ReservationOrder {

	private BookInformation bookInformation;
	public void setBookInformation(BookInformation bookInformation) {
		this.bookInformation = bookInformation;
	}

	private User user;
	private LocalDate date;

	public BookInformation getBookInformation() {
		return bookInformation;
	}

	public User getUser() {
		return user;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
