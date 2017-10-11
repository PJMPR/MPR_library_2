package library.domain;

import java.util.Date;

public class ReservationOrder {

	//private BookInformation bookInformation;
	private User user;
	private Date date;



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
