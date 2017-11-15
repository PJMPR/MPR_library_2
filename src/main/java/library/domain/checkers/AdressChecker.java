package library.domain.checkers;

import library.domain.Address;

public class AdressChecker {

	public boolean validAdressStreet(Address adress) {
		// TODO Auto-generated method stub
		return adress.getStreet() != null && !adress.getStreet().isEmpty();
	}

	public boolean validAdressCity(Address adress) {
		// TODO Auto-generated method stub
		return adress.getCity() != null && !adress.getCity().isEmpty();
	}

	public boolean validAdressPostal(Address adress) {
		return adress.getPostalCode() != null && !adress.getPostalCode().isEmpty() && adress.getPostalCode().matches("[0-9]{2}-[0-9]{3}");
	}

	public boolean validAdressApt(Address adress) {
		// TODO Auto-generated method stub
		return adress.getApNumber() != null && !adress.getApNumber().isEmpty();
	}

}
