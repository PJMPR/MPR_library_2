package library.domain.checkers;

import static org.junit.Assert.*;

import library.domain.Genre;

import org.junit.Test;

public class GenreCheckerTest {
   
    @Test
    public void test_genre_checker_should_check_genre_name() {
       
        GenreChecker checker = new GenreChecker();
       
        Genre genreWithName = new Genre();
        genreWithName.setName("a");
        Genre genreWithhNullName = new Genre();
        Genre genreWithEnmptyStringName = new Genre();
        genreWithEnmptyStringName.setName("");
       
        boolean isGenreValid = checker.validGenreName(genreWithName);
        boolean isGenreWithNullNameValid = checker.validGenreName(genreWithhNullName);
        boolean isGenreWithEmtyStrngNameValid = checker.validGenreName(genreWithEnmptyStringName);
       
        assertTrue("Genre with name should be a valid genre", isGenreValid);
        assertFalse("Genre with null name should be invalid",isGenreWithNullNameValid);
        assertFalse("Genre with empty string name should be invalid", isGenreWithEmtyStrngNameValid);
           
    }

}
