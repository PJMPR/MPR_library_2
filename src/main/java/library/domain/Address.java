package library.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="adres")
@NamedQueries({
	@NamedQuery(name="adres.all", query="SELECT a FROM Address a"),
	@NamedQuery(name="adres.id", query="SELECT a FROM Address a WHERE a.id=:id")
})
public class Address implements IHaveId {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String city;
	private String postalCode;
	private String street;
	private String apNumber;
	
	@ManyToOne
	private Profile profile;
	
	
	public Address(String city, String postalCode, String street, String apNumber) {
		super();
		this.city = city;
		this.postalCode = postalCode;
		this.street = street;
		this.apNumber = apNumber;
	}
	public Address() {
		super();
	}
	
	
	
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
