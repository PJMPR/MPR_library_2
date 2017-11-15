package library.dao.repositories;

import java.util.List;

import library.domain.Notification;

public interface INotificationRepository extends IRepository<Notification> {
	
	public List<Notification> withType(String notification_type);

}
