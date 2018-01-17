package library.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="wydawca")
@NamedQueries({
	@NamedQuery(name="publishers.all", query="SELECT p FROM Publisher p"),
	@NamedQuery(name="publishers.id", query="SELECT p FROM Publisher p WHERE p.id=:id")
})

public class Publisher implements IHaveId{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
    private int phoneNumber;
    private String emailAdress;
    private String website;

    @OneToMany(mappedBy="publisher")
	private List<Book> books;

	public Publisher(String name, int phoneNumber, String emailAdress,
			String website) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailAdress = emailAdress;
		this.website = website;
	}

	
	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}


	public Publisher() {
		super();
	}
    
    public int getId() {
 		return id;
 	}

 	public void setId(int id) {
 		this.id = id;
 	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
	
}
