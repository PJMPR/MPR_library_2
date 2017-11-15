package library.examples;

import java.sql.Connection;
import java.util.List;


import library.dao.mappers.AdressMapper;
import library.dao.repositories.IDatabaseCatalog;
import library.dao.repositories.impl.AddressRepository;
import library.domain.Address;
import library.dao.repositories.IRepository;
import library.dao.repositories.impl.AddressRepository;


public class AddressRepositoryExample {


	public static void execute(Connection connection, IDatabaseCatalog catalog){
		catalog.addresses().createTable();
		Address adress = new Address("Gdansk", "34-123", "Brzegi", "55");
		catalog.addresses().add(adress);
		catalog.addresses().add(adress);
		catalog.addresses().add(adress);
		
		System.out.println("Count: "+ catalog.addresses().count());
    	System.out.println("last id: "+ catalog.addresses().lastId());

    	List<Address> addressWithCity = catalog.addresses().withCity("Gdansk");
		List<Address> addressWithPostal = catalog.addresses().withPostal("80-041");
    	
    	List<Address> adresses = catalog.addresses().getPage(1, 2);
    	
    	for(Address a: adresses){
    		System.out.println(a.getId());
    	}
    	
    	Address toDelete = adresses.get(0);
		catalog.addresses().delete(toDelete);
    	
    	Address updateName = adresses.get(1);
    	updateName.setCity("Radom");

		catalog.addresses().update(updateName);
	}
}
