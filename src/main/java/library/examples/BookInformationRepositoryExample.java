package library.examples;

import library.dao.repositories.IDatabaseCatalog;

import java.sql.Connection;
import java.util.List;

public class BookInformationRepositoryExample {

    public static void execute(Connection connection, IDatabaseCatalog catalog){
/*
        BookInformationRepository bookInformationRepository = new BookInformationRepository(connection, new BookInformationMapper());
        bookInformationRepository.createTable();
        BookInformation bookInformation = new BookInformation();
        bookInformation.setTitle("EXAMPLE");
        bookInformationRepository.add(bookInformation);
        bookInformationRepository.add(bookInformation);
        bookInformationRepository.add(bookInformation);

        System.out.println("Count: "+bookInformationRepository.count());
        System.out.println("last id: "+bookInformationRepository.lastId());

        List<BookInformation> bookInformations = bookInformationRepository.getPage(1,2);

        for (BookInformation bI: bookInformations){
            System.out.println(bI.getId());
        }

        BookInformation toDelete = bookInformations.get(0);
        bookInformationRepository.delete(toDelete);

        BookInformation updateTitle = bookInformations.get(1);
        updateTitle.setTitle("otherExample");

        bookInformationRepository.update(updateTitle);
        */
    }
}
