package library.domain.checkers;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import library.domain.Author;
import library.domain.Genre;
import library.domain.Section;

import org.junit.Test;

public class SectionCheckerTest {
	
	@Test
	public void test_section_checker_should_check_section_name() {
		
		SectionChecker checker = new SectionChecker();
		
		Section sectionWithName = new Section();
		sectionWithName.setName("a");
		Section sectionWithhNullName = new Section();
		Section sectionWithEnmptyStringName = new Section();
		sectionWithEnmptyStringName.setName("");
		
		boolean isActorValid = checker.validSectionName(sectionWithName);
		boolean isActorWithNullNameValid = checker.validSectionName(sectionWithhNullName);
		boolean isActorWithEmtyStrngNameValid = checker.validSectionName(sectionWithEnmptyStringName);
		
		assertTrue("Section with name should be a valid actor", isActorValid);
		assertFalse("Section with null name should be invalid",isActorWithNullNameValid);
		assertFalse("Section with empty string name should be invalid", isActorWithEmtyStrngNameValid);	
	}
	
	@Test
	public void test_section_checker_should_check_section_genres() {
		
		SectionChecker checker = new SectionChecker();
		
		Section sectionWithGenres = new Section();
		List<Genre> genres = new ArrayList<Genre>();
		sectionWithGenres.setGenres(genres);
		Section sectionWithhNullGenres = new Section();

		
		boolean isActorValid = checker.validSectionGenres(sectionWithGenres);
		boolean isActorWithNullGenresValid = checker.validSectionGenres(sectionWithhNullGenres);

		
		assertTrue("Section with generes should be a valid actor", isActorValid);
		assertFalse("Section with null generes should be invalid",isActorWithNullGenresValid);
	}
	
}
