package library.domain.checkers;

import library.domain.Author;

public class AuthorChecker {

	public boolean validAuthorName(Author author) {
		return author.getName() != null && !author.getName().isEmpty();
	}

}
