package library.examples;

import java.sql.Connection;
import java.util.List;

import library.dao.mappers.AuthorMapper;
import library.dao.mappers.NotificationMapper;
import library.dao.repositories.IRepository;
import library.dao.repositories.impl.AuthorRepository;
import library.dao.repositories.impl.NotificationRepository;
import library.domain.Author;
import library.domain.Notification;

public class NotificationRepositoryExample {
	public static void execute(Connection connection){

    	IRepository<Notification> notificationRepository = new NotificationRepository(connection, new NotificationMapper());
    	notificationRepository.createTable();
    	Notification notification = new Notification();
    	notification.setMessage("cokolwiek");
    	notification.setNotification_type("przypomnienie");
    	notificationRepository.add(notification);
    	notificationRepository.add(notification);
    	notificationRepository.add(notification);

    	System.out.println("Count: "+notificationRepository.count());
    	System.out.println("last id: "+notificationRepository.lastId());
    	
    	List<Notification> notifications = notificationRepository.getPage(1, 2);
    	
    	for(Notification n: notifications){
    		System.out.println(n.getId());
    	}
		
    	Notification toDelete = notifications.get(0);
    	notificationRepository.delete(toDelete);
    	
    	Notification updateMessage = notifications.get(1);
    	updateMessage.setMessage("Zaplac");
    	
    	notificationRepository.update(updateMessage);
    	
	}
}
