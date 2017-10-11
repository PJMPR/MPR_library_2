package library.domain;

public class Adress {
	private String city;
	private String postalCode;
	private String street;
	private String apNumber;
	
	public Adress(String city, String postalCode, String street, String apNumber) {
		super();
		this.city = city;
		this.postalCode = postalCode;
		this.street = street;
		this.apNumber = apNumber;
	}
	public Adress() {
		super();
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getApNumber() {
		return apNumber;
	}
	public void setApNumber(String apNumber) {
		this.apNumber = apNumber;
	}
}
