package library.domain.checkers;

import library.domain.Profile;

public class ProfileChecker {
	
	
	public boolean validProfileName(Profile profile) {
		return profile.getName() != null && !profile.getName().isEmpty();
	}

	public boolean validProfileSurname(Profile profile) {
		return profile.getSurname() != null && !profile.getSurname().isEmpty();
	}
	
	public boolean validProfilePesel(Profile profile) {
		return profile.getPesel() != null && !profile.getPesel().isEmpty();
	}
	
	public boolean validProfilePhone(Profile profile) {
		return profile.getPhone() != null && !profile.getPhone().isEmpty();
	}

	public boolean validProfileMail(Profile profile) {
		return profile.getMail() != null && !profile.getMail().isEmpty();
	}
	
}
