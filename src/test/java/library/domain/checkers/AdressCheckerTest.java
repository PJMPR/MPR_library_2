package library.domain.checkers;

import static org.junit.Assert.*;
import library.domain.Adress;
import library.domain.Author;

import org.junit.Test;

public class AdressCheckerTest {

	@Test
	public void test() {
		AdressChecker checker = new AdressChecker();

		/*authorWithName.setName("a");
		Author authorWithhNullName = new Author();
		Author authorWithEnmptyStringName = new Author();
		authorWithEnmptyStringName.setName("");
		
		boolean isActorValid = checker.validAuthorName(authorWithName);
		boolean isActorWithNullNameValid = checker.validAuthorName(authorWithhNullName);
		boolean isActorWithEmtyStrngNameValid = checker.validAuthorName(authorWithEnmptyStringName);
		
		assertTrue("Author with name should be a valid actor", isActorValid);
		assertFalse("Author with null name should be invalid",isActorWithNullNameValid);
		assertFalse("author with empty string name should be invalid", isActorWithEmtyStrngNameValid); */
		
		Adress adressWithNullStreet = new Adress();
		Adress adressWithEmptyStringStreet = new Adress();
		adressWithEmptyStringStreet.setStreet("");
		
		boolean nullStreetIsValid = checker.validAdressStreet(adressWithNullStreet);
		boolean isAStreetWithEmptyStringValid = checker.validAdressStreet(adressWithEmptyStringStreet);
		
		assertFalse("Street null field should be invalid", nullStreetIsValid);
		assertFalse("Adress with empty street name should be invalid", isAStreetWithEmptyStringValid);
		
		// ==================================================
		Adress adressWithNullCity = new Adress();
		Adress adressWithEmptyStringCity = new Adress();
		adressWithEmptyStringCity.setCity("");
		
		boolean nullCityIsValid = checker.validAdressStreet(adressWithNullCity);
		boolean isACityWithEmptyStringValid = checker.validAdressCity(adressWithEmptyStringCity);
		
		assertFalse("City with null field should be invalid", nullCityIsValid);
		assertFalse("Adress with empty city name should be invalid", isACityWithEmptyStringValid);
		
		// =====================================================
		Adress adressWithNullPostal = new Adress();
		Adress adressWithEmptyStringPostal = new Adress();
		adressWithEmptyStringPostal.setPostalCode("");
		
		boolean nullPostalIsValid = checker.validAdressSPostal(adressWithNullPostal);
		boolean isAPostalWithEmptyStringValid = checker.validAdressStreet(adressWithEmptyStringPostal);
		
		assertFalse("Postal code with null field should be invalid", nullPostalIsValid);
		assertFalse("Adress with empty postal code name should be invalid", isAPostalWithEmptyStringValid);
		
		// ======================================================
		Adress adressWithNullApt = new Adress();
		Adress adressWithEmptyStringApt = new Adress();
		adressWithEmptyStringApt.setStreet("");
		
		boolean nullAptIsValid = checker.validAdressApt(adressWithNullApt);
		boolean isAptWithEmptyStringValid = checker.validAdressStreet(adressWithEmptyStringStreet);
		
		assertFalse("Apt number with null field should be invalid", nullAptIsValid);
		assertFalse("Adress with empty apt number should be invalid", isAptWithEmptyStringValid);
	}

}
