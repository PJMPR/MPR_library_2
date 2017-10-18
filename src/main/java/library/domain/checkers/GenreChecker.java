package library.domain.checkers;

import library.domain.Genre;

public class GenreChecker {
   
    public boolean validGenreName(Genre genre) {
        return genre.getName() != null && !genre.getName().isEmpty();
    }

}