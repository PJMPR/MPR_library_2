package library.dao.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import library.domain.Publisher;

public class PublisherRepository extends RepositoryBase{
  
    Connection connection;
    private boolean tableExists;

    
    
    public PublisherRepository(Connection connection) {

        try {
            connection = connection;
           
            insert = connection.prepareStatement(""
                    + "INSERT INTO publisher(name,phoneNumber,emailAdress,website)"
                    + "VALUES(?,?,?,?)");
            
			selectById = connection.prepareStatement(""
					+ "SELECT * FROM publisher WHERE id=?");
			
			lastId = connection.prepareStatement(""
					+ "SELECT MAX(id) FROM publisher"
					+ "");
			
			count = connection.prepareStatement(""
					+ "SELECT COUNT(*) FROM publisher"
					+ "");
			
			selectByPage = connection.prepareStatement(""
					+ "SELECT * FROM publisher OFFSET ? LIMIT ?"
					+ "");
			
			delete = connection.prepareStatement(""
					+ "DELETE FROM publisher WHERE id=?");
			
			update = connection.prepareStatement(""
					+ "UPDATE publisher SET (name, phoneNumber, emailAdress, website)=(?,?,?,?) WHERE id=?");
            
            ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
          
            
            
            while(rs.next()){
                if(rs.getString("TABLE_NAME").equalsIgnoreCase("publisher")){
                    tableExists = true;
                    break;
                }
            }
          
        } catch (SQLException e) {
            e.printStackTrace();
        }

}
    
	public void delete(Publisher publisher){
		
		try {
			delete.setInt(1, publisher.getId());
			delete.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update(Publisher publisher){
		
		try {
			
			update.setString(1, publisher.getName());
			update.setInt(2, publisher.getPhoneNumber());
			update.setString(3, publisher.getEmailAdress());
			update.setString(4, publisher.getWebsite());
			update.setInt(5, publisher.getId());
			update.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
    
	
	public List<Publisher> getPage(int offset, int limit){
		
		List<Publisher> result = new ArrayList<Publisher>();
		try {
			selectByPage.setInt(1, offset);
			selectByPage.setInt(2, limit);
			ResultSet rs = selectByPage.executeQuery();
			while(rs.next()){
				Publisher a = new Publisher();
				a.setId(rs.getInt("id"));
				a.setName(rs.getString("name"));
				a.setPhoneNumber(rs.getInt("phoneNumber"));
				a.setEmailAdress(rs.getString("emailAdress"));
				a.setWebsite(rs.getString("website"));
				result.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Publisher get(int id){
		Publisher publisher = null;
				
		try {
			selectById.setInt(1, id);
			ResultSet rs = selectById.executeQuery();
			while(rs.next()){
				publisher=new Publisher();
				publisher.setId(rs.getInt("id"));
				publisher.setName(rs.getString("name"));
				publisher.setPhoneNumber(rs.getInt("phoneNumber"));
				publisher.setEmailAdress(rs.getString("empublisherilpublisherdress"));
				publisher.setWebsite(rs.getString("website"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
				
		return publisher;
		
	}
    
    
    
public void add(Publisher publisher){
       
        try {
            insert.setString(1, publisher.getName());
            insert.setInt(2, publisher.getPhoneNumber());
            insert.setString(3, publisher.getEmailAdress());
            insert.setString(4, publisher.getWebsite());
            insert.executeUpdate();
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
    }

public void createTable(){
  
    String createTableSql = "CREATE TABLE publisher("
            + "id bigint GENERATED BY DEFAULT AS IDENTITY,"
            + "name VARCHAR(20),"
            + "emailAdress VARCHAR(50),"
            + "website VARCHAR(40),"
            + "phoneNumber INT"
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