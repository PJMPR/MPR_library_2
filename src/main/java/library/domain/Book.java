package library.domain;

import java.time.LocalDate;

public class Book {
    private int id;
//    private BookInformation bookInformation;
    private Publisher publisher;
    private LocalDate releaseDate;
    private LocalDate additionDate;
    private String language;
    private Section section;
    private boolean isAvailable;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public BookInformation getBookInformation() {
//        return bookInformation;
//    }
//
//    public void setBookInformation(BookInformation bookInformation) {
//        this.bookInformation = bookInformation;
//    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public LocalDate getAdditionDate() {
        return additionDate;
    }

    public void setAdditionDate(LocalDate additionDate) {
        this.additionDate = additionDate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
