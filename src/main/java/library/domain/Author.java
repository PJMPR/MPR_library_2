package library.domain;

public class Author {

    private String name;
    private String secondName;
    private String surname;

    public Author(String name, String secondName, String surname) {
        this.name = name;
        this.secondName = secondName;
        this.surname = surname;
    }

    public Author() {
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}