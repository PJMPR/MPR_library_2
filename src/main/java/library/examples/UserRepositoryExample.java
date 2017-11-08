package library.examples;

import java.sql.Connection;
import java.util.List;

import library.dao.mappers.AuthorMapper;
import library.dao.mappers.UserMapper;
import library.dao.repositories.AuthorRepository;
import library.dao.repositories.IRepository;
import library.dao.repositories.UserRepository;
import library.domain.Author;
import library.domain.User;

public class UserRepositoryExample {
	
	public static void execute(Connection connection){

		IRepository<User> userRepository = new UserRepository(connection, new UserMapper());
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
