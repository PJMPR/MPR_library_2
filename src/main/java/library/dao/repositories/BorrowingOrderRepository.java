package library.dao.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BorrowingOrderRepository {

	Connection connection;
	private boolean tableExists;
	
	public BorrowingOrderRepository() {

		try {
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
			
			ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
			
			while(rs.next()){
				if(rs.getString("TABLE_NAME").equalsIgnoreCase("borrowingorder")){
					tableExists = true;
					break;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void createTable(){
		
		String createTableSql = "CREATE TABLE borrowingorder("
				+ "id bigint GENERATED BY DEFAULT AS IDENTITY,"
				+ "datefrom DATETIME,"
				+ "dateto DATETIME"
				+ ")";
		
		try {
			Statement createTable = connection.createStatement();
			if(!tableExists)
			createTable.executeUpdate(createTableSql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
