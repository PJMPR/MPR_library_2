package library.examples;

import java.util.List;

import library.dao.repositories.UserRepository;
import library.domain.Author;
import library.domain.User;

public class UserRepositoryExample {
	
	public static void execute(){

    	UserRepository userRepository = new UserRepository();
    	userRepository.createTable();
    	User user = new User();
    	user.setLogin("Karol");
    	user.setPassword("kkk");
    	user.setStatus(true);
    	
    	userRepository.add(user);
    	userRepository.add(user);
    	userRepository.add(user);

    	System.out.println("Count: "+userRepository.count());
    	System.out.println("last id: "+userRepository.lastId());
    	
    	List<User> users = userRepository.getPage(1, 2);
    	
    	for(User a: users){
    		System.out.println(a.getId());
    	}
    	User toDelete = users.get(0);
    	userRepository.delete(toDelete);
    	
    	User updateLogin = users.get(1);
    	updateLogin.setLogin("ewik");
    	
    	userRepository.update(updateLogin);
	}

}
