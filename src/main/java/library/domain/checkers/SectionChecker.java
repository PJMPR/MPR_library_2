package library.domain.checkers;

import library.domain.Section;

public class SectionChecker {

	public boolean validSectionName(Section section){
		return section.getName() != null && !section.getName().isEmpty();
	}
	
	public boolean validSectionGenres(Section section){
		return section.getGenres() != null;
	}
}
