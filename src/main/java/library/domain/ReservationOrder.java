package library.domain;

import java.sql.Date;

public class ReservationOrder implements IHaveId{

	private Book book;
	
	private int Id;
	private User user;
	private int userId;
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
	
	public int getUserId() {
		return userId;
	}
	
	

	public void setId(int id) {
		Id = id;
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

	public ReservationOrder(Book book, User user,
			int userId, Date date) {
		super();
		this.book = book;
		this.user = user;
		this.userId = userId;
		this.date = date;
	}

	public ReservationOrder() {
		super();
	}
	
	
}
