package library.domain;

import java.sql.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="rezerwacje")
@NamedQueries({
	@NamedQuery(name="reservationorders.all", query="SELECT r FROM ReservationOrder r"),
	@NamedQuery(name="reservationorders.id", query="SELECT r FROM ReservationOrder r WHERE r.id=:id")
})

public class ReservationOrder implements IHaveId{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@OneToOne
	private Book book;
	
	@OneToOne
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
