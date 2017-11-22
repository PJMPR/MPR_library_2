package library.examples;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import library.dao.mappers.AuthorMapper;
import library.dao.mappers.NotificationMapper;
import library.dao.repositories.IDatabaseCatalog;
import library.dao.repositories.IRepository;
import library.dao.repositories.impl.AuthorRepository;
import library.dao.repositories.impl.NotificationRepository;
import library.domain.Author;
import library.domain.Notification;

public class NotificationRepositoryExample {
	public static void execute(Connection connection, IDatabaseCatalog catalog) throws SQLException{

    	IRepository<Notification> notificationRepository = catalog.notifications();
    	notificationRepository.createTable();
    	Notification notification = new Notification();
    	notification.setMessage("cokolwiek");
    	notification.setNotification_type("przypomnienie");
    	notificationRepository.add(notification);
    	notificationRepository.add(notification);
    	notificationRepository.add(notification);

    	System.out.println("Count: "+ catalog.notifications().count());
    	System.out.println("last id: "+ catalog.notifications().lastId());
    	
    	List<Notification> notificationsWithTypeA = catalog.notifications().withType("A");
    	List<Notification> notifications = catalog.notifications().getPage(1, 2);
    	
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
