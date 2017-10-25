package library.examples;

import java.util.List;

import library.dao.repositories.AdressRepository;
import library.domain.Adress;
import library.domain.Author;

public class AdressRepositoryExample {

	
	public static void execute(){
		AdressRepository adressRepo = new AdressRepository();
		adressRepo.createtable();
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
