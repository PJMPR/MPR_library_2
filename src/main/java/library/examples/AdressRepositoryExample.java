package library.examples;

import java.sql.Connection;
import java.util.List;

import library.dao.mappers.AdressMapper;
import library.dao.repositories.AdressRepository;
import library.domain.Adress;

public class AdressRepositoryExample {

	
	public static void execute(Connection connection){
		AdressRepository adressRepo = new AdressRepository(connection, new AdressMapper());
		adressRepo.createTable();
		Adress adress = new Adress("Gdansk", "34-123", "Brzegi", "55");
		adressRepo.add(adress);
		adressRepo.add(adress);
		adressRepo.add(adress);
		
		System.out.println("Count: "+adressRepo.count());
    	System.out.println("last id: "+adressRepo.lastId());
    	
    	List<Adress> adresses = adressRepo.getPage(1, 2);
    	
    	for(Adress a: adresses){
    		System.out.println(a.getId());
    	}
    	
    	Adress toDelete = adresses.get(0);
    	adressRepo.delete(toDelete);
    	
    	Adress updateName = adresses.get(1);
    	updateName.setCity("Radom");
    	
    	adressRepo.update(updateName);
	}
}
