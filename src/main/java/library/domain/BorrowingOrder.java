package library.domain;

import java.util.Calendar;
import java.util.Date;

public class BorrowingOrder {

	private User user;
	private Book book;
	private Date dateFrom;
	private Date dateTo;
	
	public BorrowingOrder(User user, Book book) {
		this.user = user;
		this.book = book;
		
		SetDates();
	}
	
	private void SetDates() {
		Calendar calInstance = Calendar.getInstance();
		dateFrom = calInstance.getTime();
		calInstance.add(Calendar.MONTH, 1);
		dateTo = calInstance.getTime();
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
