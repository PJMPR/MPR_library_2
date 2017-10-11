package library.domain.checkers;

import static org.junit.Assert.*;

import org.junit.Test;

import library.domain.Author;

public class AuthorCheckerTest {

	@Test
	public void test_author_checker_should_check_author_name() {

		AuthorChecker checker = new AuthorChecker();

		Author authorWithName = new Author();
		authorWithName.setName("a");
		Author authorWithNullName = new Author();
		Author authorWithEmptyStringName = new Author();
		authorWithEmptyStringName.setName("");

		boolean isActorValid = checker.validAuthorName(authorWithName);
		boolean isActorWithNullNameValid = checker.validAuthorName(authorWithNullName);
		boolean isActorWithEmptyStringNameValid = checker.validAuthorName(authorWithEmptyStringName);

		assertTrue("Author with name should be a valid actor", isActorValid);
		assertFalse("Author with null name should be invalid",isActorWithNullNameValid);
		assertFalse("Author with empty string name should be invalid", isActorWithEmptyStringNameValid);

	}

}

