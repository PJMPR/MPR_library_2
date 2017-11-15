package library.examples;

import java.sql.Connection;
import java.util.List;

import library.dao.mappers.AdressMapper;
import library.dao.repositories.impl.AddressRepository;
import library.domain.Address;

public class AddressRepositoryExample {

	
	public static void execute(Connection connection){
		AddressRepository adressRepo = new AddressRepository(connection, new AdressMapper());
		adressRepo.createTable();
		Address adress = new Address("Gdansk", "34-123", "Brzegi", "55");
		adressRepo.add(adress);
		adressRepo.add(adress);
		adressRepo.add(adress);
		
		System.out.println("Count: "+adressRepo.count());
    	System.out.println("last id: "+adressRepo.lastId());
    	
    	List<Address> adresses = adressRepo.getPage(1, 2);
    	
    	for(Address a: adresses){
    		System.out.println(a.getId());
    	}
    	
    	Address toDelete = adresses.get(0);
    	adressRepo.delete(toDelete);
    	
    	Address updateName = adresses.get(1);
    	updateName.setCity("Radom");
    	
    	adressRepo.update(updateName);
	}
}
