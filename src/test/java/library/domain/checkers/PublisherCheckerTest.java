package library.domain.checkers;

import library.domain.Publisher;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by Owner on 11/10/2017.
 */
public class PublisherCheckerTest {
    @Test
    public void test_publisher_checker_should_check_publisher_name() {
        PublisherChecker checker = new PublisherChecker();

        Publisher publisherWithName= new Publisher();
        publisherWithName.setName("b");
        Publisher publisherWithNullName= new Publisher();
        Publisher publisherWithEmptyName= new Publisher();
        publisherWithEmptyName.setName("");


        boolean isPublisherNameValid = checker.validPublisherName(publisherWithName);
        boolean isPublisherWithNullNameValid = checker.validPublisherName(publisherWithNullName);
        boolean isPublisherWithEmtyStrngNameValid = checker.validPublisherName(publisherWithEmptyName);

        assertTrue("Publisher is a valid publisher", isPublisherNameValid);
        assertFalse("Publisher  with null name is invalid",isPublisherWithNullNameValid);
        assertFalse("Publisher with empty name is invalid", isPublisherWithEmtyStrngNameValid);

        Publisher publisherWithEmail = new Publisher();
        publisherWithEmail.setEmailAdress("a@com");
        Publisher publisherWithNullEmail = new Publisher();
        Publisher publisherWithEmptyStringEmail = new Publisher();
        publisherWithEmptyStringEmail.setEmailAdress("");

        boolean isPublisherEmailValid = checker.validEmailAdress(publisherWithEmail);
        boolean isPublisherWithNullEmailValid = checker.validEmailAdress(publisherWithNullEmail);
        boolean isPublisherEmailEmptyStringValid = checker.validEmailAdress(publisherWithEmptyStringEmail);

        assertTrue("Publisher is a valid publisher", isPublisherEmailValid);
        assertFalse("Publisher  with null email is invalid",isPublisherWithNullEmailValid);
        assertFalse("Publisher with empty email is invalid", isPublisherEmailEmptyStringValid);
//hahahhaha
        Publisher publisherWithWebsite = new Publisher();
        publisherWithWebsite.setWebsite("www.a.com");
        Publisher publisherWithNullWebsite = new Publisher();
        Publisher publisherWithEmptyStringWebsite = new Publisher();
        publisherWithEmptyStringWebsite.setWebsite("");

        boolean isPublisherWebsiteValid = checker.validWebsite(publisherWithWebsite);
        boolean isPublisherWithNullWebsiteValid = checker.validWebsite(publisherWithNullWebsite);
        boolean isPublisherWebsiteEmptyStringValid = checker.validWebsite(publisherWithEmptyStringWebsite);

        assertTrue("Publisher is a valid publisher", isPublisherWebsiteValid);
        assertFalse("Publisher  with null Website is invalid",isPublisherWithNullWebsiteValid);
        assertFalse("Publisher with empty Website is invalid", isPublisherWebsiteEmptyStringValid);









    }
}
