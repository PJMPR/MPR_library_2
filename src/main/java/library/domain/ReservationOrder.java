package library.domain;

import java.sql.Date;

public class ReservationOrder implements IHaveId{

	private Book book;
	private int Id;
	private User user;
	private Date date;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getId(){
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

	public void setDate(Date date2) {
		this.date = date2;
	}

	public ReservationOrder(Book book, User user, Date date) {
		super();
		this.book = book;
		this.user = user;
		this.date = date;
	}

	public ReservationOrder() {
		super();
	}

	public void setDate(long time) {
		this.date = new Date(time);
		
	}
	
	
}
