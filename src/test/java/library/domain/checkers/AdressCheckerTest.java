package library.domain.checkers;

import static org.junit.Assert.*;
import library.domain.Adress;
import library.domain.Author;

import org.junit.Test;

public class AdressCheckerTest {
	AdressChecker checker = new AdressChecker();
	
	@Test
	public void test_street() {
		
		
		Adress adressWithNullStreet = new Adress();
		Adress adressWithEmptyStringStreet = new Adress();
		adressWithEmptyStringStreet.setStreet("");
		
		boolean nullStreetIsValid = checker.validAdressStreet(adressWithNullStreet);
		boolean isAStreetWithEmptyStringValid = checker.validAdressStreet(adressWithEmptyStringStreet);
		
		assertFalse("Street null field should be invalid", nullStreetIsValid);
		assertFalse("Adress with empty street name should be invalid", isAStreetWithEmptyStringValid);
	}
	@Test
	public void test_city() {
		Adress adressWithNullCity = new Adress();
		Adress adressWithEmptyStringCity = new Adress();
		adressWithEmptyStringCity.setCity("");
		
		boolean nullCityIsValid = checker.validAdressCity(adressWithNullCity);
		boolean isACityWithEmptyStringValid = checker.validAdressCity(adressWithEmptyStringCity);
		
		assertFalse("City with null field should be invalid", nullCityIsValid);
		assertFalse("Adress with empty city name should be invalid", isACityWithEmptyStringValid);
	}
		
	@Test
	public void test_postal_code() {
		Adress adressWithNullPostal = new Adress();
		Adress adressWithEmptyStringPostal = new Adress();
		adressWithEmptyStringPostal.setPostalCode("");
		Adress adressWithWrongPostalStyle = new Adress();
		adressWithWrongPostalStyle.setPostalCode("12345");
		
		boolean nullPostalIsValid = checker.validAdressPostal(adressWithNullPostal);
		boolean isAPostalWithEmptyStringValid = checker.validAdressPostal(adressWithEmptyStringPostal);
		boolean isPostalCodeValid = checker.validAdressPostal(adressWithWrongPostalStyle);
				
		assertFalse("Wrong postal style should be invalid", isPostalCodeValid);
		assertFalse("Postal code with null field should be invalid", nullPostalIsValid);
		assertFalse("Adress with empty postal code name should be invalid", isAPostalWithEmptyStringValid);
	}	
	
	@Test
	public void test_apt_number() {
		Adress adressWithNullApt = new Adress();
		Adress adressWithEmptyStringApt = new Adress();
		adressWithEmptyStringApt.setStreet("");
		
		boolean nullAptIsValid = checker.validAdressApt(adressWithNullApt);
		boolean isAptWithEmptyStringValid = checker.validAdressStreet(adressWithEmptyStringApt);
		
		assertFalse("Apt number with null field should be invalid", nullAptIsValid);
		assertFalse("Adress with empty apt number should be invalid", isAptWithEmptyStringValid);
	}

}
