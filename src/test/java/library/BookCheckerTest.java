package library.domain.checkers;

import library.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
        BookChecker.setAuthors(new List<Author>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Author> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Author author) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Author> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Author> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Author get(int index) {
                return null;
            }

            @Override
            public Author set(int index, Author element) {
                return null;
            }

            @Override
            public void add(int index, Author element) {

            }

            @Override
            public Author remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Author> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Author> listIterator(int index) {
                return null;
            }

            @Override
            public List<Author> subList(int fromIndex, int toIndex) {
                return null;
            }
        });

        boolean isListValid = checker.validList(BookChecker);

        assertTrue(isListValid);
    }
}