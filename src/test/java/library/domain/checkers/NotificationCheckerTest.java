package library.domain.checkers;

import static org.junit.Assert.*;
import library.domain.Author;
import library.domain.Notification;
import library.domain.User;

import org.junit.Test;

public class NotificationCheckerTest {

	@Test
	public void test_notification_checker_should_check_notification_user(){
		
		NotificationChecker checker = new NotificationChecker();
		
		Notification notificationWithUser = new Notification();
		notificationWithUser.setUser(new User());
		Notification notificationWithNullUser = new Notification();
		
		boolean isNotificationValid = checker.vaildNotificationUser(notificationWithUser);
		boolean isNotificationWithNullUserValid = checker.vaildNotificationUser(notificationWithNullUser);
		
		assertTrue("Notification with user should be valid Notification", isNotificationValid);
		assertFalse("Notification with null user should ba invalid", isNotificationWithNullUserValid);
	}
	
	@Test
	public void test_notification_checker_should_check_notification_message() {
		
		NotificationChecker checker = new NotificationChecker();
		
		Notification notificationWithMessage =  new Notification();
		notificationWithMessage.setMessage("a");
		Notification notificationWithNullMessage =  new Notification();
		Notification notificationWithEmptyStringMessage =  new Notification();
		notificationWithEmptyStringMessage.setMessage("");
		
		boolean isNotificationValid = checker.validNotificationMessage(notificationWithMessage);
		boolean isNotificationWithNullMessageValid = checker.validNotificationMessage(notificationWithNullMessage);
		boolean isNotificationWithEmtyStrngMessageValid = checker.validNotificationMessage(notificationWithEmptyStringMessage);
		
		assertTrue("Notification with message should be a valid Notification", isNotificationValid);
		assertFalse("Notification with null message should be invalid",isNotificationWithNullMessageValid);
		assertFalse("Notification with empty string message should be invalid", isNotificationWithEmtyStrngMessageValid);		
	}
	
	@Test
	public void test_notification_checker_should_check_notification_type() {
		
		NotificationChecker checker = new NotificationChecker();
		
		Notification notificationWithType =  new Notification();
		notificationWithType.setNotification_type("a");
		Notification notificationWithNullType =  new Notification();
		Notification notificationWithEmptyStringType =  new Notification();
		notificationWithEmptyStringType.setNotification_type("");
		
		boolean isNotificationValid = checker.validNotificationType(notificationWithType);
		boolean isNotificationWithNullTypeValid = checker.validNotificationType(notificationWithNullType);
		boolean isNotificationWithEmtyStrngTypeValid = checker.validNotificationType(notificationWithEmptyStringType);
		
		assertTrue("Notification with type should be a valid Notification", isNotificationValid);
		assertFalse("Notification with null type should be invalid",isNotificationWithNullTypeValid);
		//assertFalse("Notification with empty string type should be invalid", isNotificationWithEmtyStrngTypeValid);
			
	}
}
