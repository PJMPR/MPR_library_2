package library.dao.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class NotificationRepository {

	Connection connection;
	
	public NotificationRepository() {

		try {
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void createTable(){
		
		String createTableSql = "CREATE TABLE notification("
				+ "id bigint GENERATED BY DEFAULT AS IDENTITY,"
				+ "message VARCHAR(64),"
				+ "notificationtype VARCHAR(16)"
				+ ")";
		
		try {
			Statement createTable = connection.createStatement();
			createTable.executeUpdate(createTableSql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
