package library.domain.checkers;

import library.domain.Adress;

public class AdressChecker {

	public boolean validAdressStreet(Adress adress) {
		// TODO Auto-generated method stub
		return adress.getStreet() != null && !adress.getStreet().isEmpty();
	}

	public boolean validAdressCity(Adress adress) {
		// TODO Auto-generated method stub
		return adress.getCity() != null && !adress.getCity().isEmpty();
	}

	public boolean validAdressSPostal(Adress adress) {
		// TODO Auto-generated method stub
		return adress.getPostalCode() != null && !adress.getPostalCode().isEmpty();
	}

	public boolean validAdressApt(Adress adress) {
		// TODO Auto-generated method stub
		return adress.getApNumber() != null && !adress.getApNumber().isEmpty();
	}

}
