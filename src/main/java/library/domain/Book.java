package library.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="books")
@NamedQueries({
	@NamedQuery(name="books.all", query="SELECT b FROM Book b"),
	@NamedQuery(name="books.id", query="SELECT b FROM Book b WHERE b.id=:id")
})
public class Book implements IHaveId{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //private Publisher publisher;
    //private Date releaseDate;
    //private Date additionDate;
    private String language;
    //private Section section;
    private boolean isAvailable;
    private String title;
    
    @ManyToMany(mappedBy="authors")
    List<Author> author;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    
    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Author> getAuthor() {
		return author;
	}

	public void setAuthor(List<Author> author) {
		this.author = author;
	}
/*
	public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getAdditionDate() {
        return additionDate;
    }

    public void setAdditionDate(Date additionDate) {
        this.additionDate = additionDate;
    }
*/
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    /*
    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
	*/
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


    
}
