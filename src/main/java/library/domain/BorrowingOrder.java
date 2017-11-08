package library.domain;

import java.util.Calendar;
import java.util.Date;

public class BorrowingOrder implements IHaveId{

	private int id;
	private User user;
	private Book book;
	private Date dateFrom;
	private Date dateTo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public BorrowingOrder(){
		
	}
	
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}


	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public void setBook(Book book) {
		this.book = book;
	}


	public User getUser() {
		return user;
	}

	public Book getBook() {
		return book;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}
		
}
