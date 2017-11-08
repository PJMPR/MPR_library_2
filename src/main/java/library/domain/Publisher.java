package library.domain;

public class Publisher implements IHaveId{
	
	private int id;
	private String name;
    private int phoneNumber;
    private String emailAdress;
    private String website;


	public Publisher(String name, int phoneNumber, String emailAdress,
			String website) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailAdress = emailAdress;
		this.website = website;
	}

	public Publisher() {
		super();
	}
    
    public int getId() {
 		return id;
 	}

 	public void setId(int id) {
 		this.id = id;
 	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
	
}
