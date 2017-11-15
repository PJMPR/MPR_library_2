package library.domain;

import java.util.ArrayList;
import java.util.List;

public class BookInformation implements IHaveId{

    private int id;

    private String title;
    List<Author> authors = new ArrayList<Author>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}