package library.domain.checkers;

import library.domain.Publisher;

public class PublisherChecker {
    public boolean validPublisherName(Publisher publisher){return publisher.getName() != null && !publisher.getName().isEmpty();}
    public boolean validEmailAdress(Publisher publisher){return publisher.getEmailAdress() != null && !publisher.getEmailAdress().isEmpty();}
    public boolean validWebsite(Publisher publisher){return publisher.getWebsite() != null && !publisher.getWebsite().isEmpty();}

}
