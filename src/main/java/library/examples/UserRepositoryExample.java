package library.examples;

import java.sql.Connection;
import java.util.List;


import library.dao.mappers.UserMapper;
import library.dao.repositories.IRepository;

import library.dao.repositories.impl.UserRepository;

import library.domain.User;
import library.dao.repositories.IDatabaseCatalog;

public class UserRepositoryExample {
	
	public static void execute(Connection connection, IDatabaseCatalog catalog){

		
		catalog.users().createTable();
		
    	User user = new User();
    	user.setLogin("Karol");
    	user.setPassword("kkk");
    	user.setStatus(true);
    	
    	catalog.users().add(user);
    	catalog.users().add(user);
    	catalog.users().add(user);

    	System.out.println("Count: "+catalog.users().count());
    	System.out.println("last id: "+catalog.users().lastId());
    	
    	List<User> userWithLoginKarol = catalog.users().withLogin("Karol");
    	List<User> userWithStatusTrue = catalog.users().withStatus(true);
    	
    	List<User> users = catalog.users().getPage(1, 2);
    	
    	for(User a: users){
    		System.out.println(a.getId());
    	}
    	User toDelete = users.get(0);
    	catalog.users().delete(toDelete);
    	
    	User updateLogin = users.get(1);
    	updateLogin.setLogin("ewik");
    	
    	catalog.users().update(updateLogin);
	}

}
