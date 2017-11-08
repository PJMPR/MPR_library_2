package library.domain;

import java.sql.Date;

public class ReservationOrder implements IHaveId{

	private BookInformation bookInformation;
	public void setBookInformation(BookInformation bookInformation) {
		this.bookInformation = bookInformation;
	}

	private int Id;
	private User user;
	private int userId;
	private Date date;

	public BookInformation getBookInformation() {
		return bookInformation;
	}

	public int getId(){
		return Id;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
