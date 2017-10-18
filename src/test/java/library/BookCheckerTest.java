package library;

import library.domain.*;
import library.domain.checkers.BookChecker;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BookCheckerTest {

    @Test
    public void validBookID(){
        BookChecker checker = new BookChecker();

        Book BookChecker = new Book();
        BookChecker.setId(543);

        boolean isIDValid = checker.validBookID(BookChecker);

        assertTrue(isIDValid);


    }

    @Test
    void validBookLanguage() {
        BookChecker checker = new BookChecker();

        Book BookChecker = new Book();
        BookChecker.setLanguage("PL");

        boolean isLanguageValid = checker.validBookLanguage(BookChecker);

        assertTrue(isLanguageValid);
    }

    @Test
    void validSection(){
        BookChecker checker = new BookChecker();

        Book BookChecker = new Book();
        BookChecker.setSection(new Section());

        boolean isSectionValid = checker.validSection(BookChecker);

        assertTrue(isSectionValid);
    }

    @Test
    void validPublisher()
    {
        BookChecker checker = new BookChecker();

        Book BookChecker = new Book();
        BookChecker.setPublisher(new Publisher());

        boolean isPublisherValid = checker.validPublisher(BookChecker);

        assertTrue(isPublisherValid);
    }

    @Test
    void validTitle()
    {
        BookChecker checker = new BookChecker();

        BookInformation BookChecker = new BookInformation();
        BookChecker.setTitle("Title");

        boolean isTitleValid = checker.validTitle(BookChecker);

        assertTrue(isTitleValid);
    }

    @Test
    void validDate()
    {
        BookChecker checker = new BookChecker();

        Book BookChecker = new Book();
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        BookChecker.setAdditionDate(tomorrow);
        BookChecker.setReleaseDate(today);

        boolean isDateValid = checker.validDate(BookChecker);

        assertTrue(isDateValid);
    }

    @Test
    void validList()
    {
        BookChecker checker = new BookChecker();
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("X","Y","Z"));

        BookInformation BookChecker = new BookInformation();
        BookChecker.setAuthors(authors);

        boolean isListValid = checker.validList(BookChecker);

        assertTrue(isListValid);
    }

}