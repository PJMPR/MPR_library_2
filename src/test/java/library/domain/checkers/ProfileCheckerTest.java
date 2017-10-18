package library.domain.checkers;

import static org.junit.Assert.*;

import org.junit.Test;

import library.domain.Profile;

public class ProfileCheckerTest {

	
	@Test
	public void test_profile_checker_should_check_profile_name() {
		
		ProfileChecker checker = new ProfileChecker();
		
		Profile ProfileWithName = new Profile();
		ProfileWithName.setName("a");
		Profile ProfileWithhNullName = new Profile();
		Profile ProfileWithEmptyStringName = new Profile();
		ProfileWithEmptyStringName.setName("");
		
		boolean isActorValid = checker.validProfileName(ProfileWithName);
		boolean isActorWithNullNameValid = checker.validProfileName(ProfileWithhNullName);
		boolean isActorWithEmptyStrngNameValid = checker.validProfileName(ProfileWithEmptyStringName);
		
		assertTrue("Profile with name should be a valid actor", isActorValid);
		assertFalse("Profile with null name should be invalid",isActorWithNullNameValid);
		assertFalse("Profile with empty string name should be invalid", isActorWithEmptyStrngNameValid);
	
		
	}
	
	@Test
	public void test_profile_checker_should_check_profile_surname() {
		
		ProfileChecker checker = new ProfileChecker();
		
		Profile ProfileWithSurname = new Profile();
		ProfileWithSurname.setSurname("a");
		Profile ProfileWithhNullSurname = new Profile();
		Profile ProfileWithEmptyStringSurname = new Profile();
		ProfileWithEmptyStringSurname.setSurname("");
		
		boolean isActorValid = checker.validProfileSurname(ProfileWithSurname);
		boolean isActorWithNullSurnameValid = checker.validProfileSurname(ProfileWithhNullSurname);
		boolean isActorWithEmptyStrngSurnameValid = checker.validProfileSurname(ProfileWithEmptyStringSurname);
		
		assertTrue("Profile with surname should be a valid actor", isActorValid);
		assertFalse("Profile with null surname should be invalid",isActorWithNullSurnameValid);
		assertFalse("Profile with empty string surname should be invalid", isActorWithEmptyStrngSurnameValid);
	
		
	}
	
	@Test
	public void test_profile_checker_should_check_profile_pesel() {
		
		ProfileChecker checker = new ProfileChecker();
		
		Profile ProfileWithPesel = new Profile();
		ProfileWithPesel.setPesel("99121202315");
		Profile ProfileWithNullPesel = new Profile();
		Profile ProfileWithEmptyStringPesel = new Profile();
		ProfileWithEmptyStringPesel.setPesel("");
		
		boolean isActorValid = checker.validProfilePesel(ProfileWithPesel);
		boolean isActorWithNullPeselValid = checker.validProfilePesel(ProfileWithNullPesel);
		boolean isActorWithEmptyStrngPeselValid = checker.validProfilePesel(ProfileWithEmptyStringPesel);
		
		assertTrue("Profile with pesel should be a valid actor", isActorValid);
		assertFalse("Profile with null pesel should be invalid",isActorWithNullPeselValid);
		assertFalse("Profile with empty string pesel should be invalid", isActorWithEmptyStrngPeselValid);
	
		
	}
	
	@Test
	public void test_profile_checker_should_check_profile_phone() {
		
		ProfileChecker checker = new ProfileChecker();
		
		Profile ProfileWithPhone = new Profile();
		ProfileWithPhone.setPhone("99999999");
		Profile ProfileWithNullPhone = new Profile();
		Profile ProfileWithEmptyStringPhone = new Profile();
		ProfileWithEmptyStringPhone.setPhone("");
		
		boolean isActorValid = checker.validProfilePhone(ProfileWithPhone);
		boolean isActorWithNullPhoneValid = checker.validProfilePhone(ProfileWithNullPhone);
		boolean isActorWithEmptyStrngPhoneValid = checker.validProfilePhone(ProfileWithEmptyStringPhone);
		
		assertTrue("Profile with phone should be a valid actor", isActorValid);
		assertFalse("Profile with null phone should be invalid",isActorWithNullPhoneValid);
		assertFalse("Profile with empty string phone should be invalid", isActorWithEmptyStrngPhoneValid);
	
		
	}
	
	@Test
	public void test_profile_checker_should_check_profile_mail() {
		
		ProfileChecker checker = new ProfileChecker();
		
		Profile ProfileWithMail = new Profile();
		ProfileWithMail.setMail("a@a.a");
		Profile ProfileWithNullMail = new Profile();
		Profile ProfileWithEmptyStringMail = new Profile();
		ProfileWithEmptyStringMail.setMail("");
		
		boolean isActorValid = checker.validProfileMail(ProfileWithMail);
		boolean isActorWithNullMailValid = checker.validProfileMail(ProfileWithNullMail);
		boolean isActorWithEmptyStrngMailValid = checker.validProfileMail(ProfileWithEmptyStringMail);
		
		assertTrue("Profile with mail should be a valid actor", isActorValid);
		assertFalse("Profile with null mail should be invalid",isActorWithNullMailValid);
		assertFalse("Profile with empty string mail should be invalid", isActorWithEmptyStrngMailValid);
	

		
	}
	}
