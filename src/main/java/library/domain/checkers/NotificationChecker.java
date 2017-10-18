package library.domain.checkers;

import library.domain.Notification;

	public class NotificationChecker {
	
	public boolean vaildNotificationUser(Notification notification){
		return notification.getUser() != null;
	}
		
	public boolean validNotificationMessage(Notification notification) {
		return notification.getMessage() != null && !notification.getMessage().isEmpty();
	}
	
	public boolean validNotificationType(Notification notification) {
		return notification.getNotification_type() != null;
	}
	
}
