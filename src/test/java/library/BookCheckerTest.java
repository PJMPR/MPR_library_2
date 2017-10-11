package library.domain.checkers;

import library.domain.*;
import org.junit.jupiter.api.Test;

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
    void validList()
    {
        BookChecker checker = new BookChecker();

        BookInformation BookChecker = new BookInformation();
        BookChecker.setAuthors(new ArrayList<Author>());

        boolean isListValid = checker.validList(BookChecker);

        assertTrue(isListValid);
    }
}