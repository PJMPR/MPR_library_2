package library.domain.checkers;

import library.domain.Book;
import library.domain.BookInformation;

public class BookChecker {

    public boolean validBookID (Book book) {
        return book.getId() != 0;
    }

    public boolean validBookLanguage (Book book) {
        return !book.getLanguage().isEmpty();
    }

    public boolean validSection (Book book) {
        return book.getSection()!=null;
    }

    public boolean validPublisher(Book book)
    {
        return book.getPublisher() != null;
    }

    public boolean validTitle(BookInformation book)
    {
        return !book.getTitle().isEmpty() && book.getTitle() !=null;
    }

    public boolean validList(BookInformation book)
    {
        return !book.getAuthors().isEmpty() && book.getAuthors() != null;
    }
}
