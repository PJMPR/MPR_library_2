package library.dao.repositories;

import library.domain.Author;
import library.domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepository extends RepositoryBase{

    
    PreparedStatement selectByLogin;
  
    public UserRepository(Connection connection){

        try {
            _connection = connection;

            insert = connection.prepareStatement(""
                                                    +"INSERT INTO user(login,password,status)"
                                                    +"VALUES(?,?,?)");

            selectByLogin = connection.prepareStatement(""
                                                            + "SELECT * FROM user WHERE login=?");

            selectById = connection.prepareStatement(""
                                                        +"SELECT * FROM user WHERE id=?");
            lastId = connection.prepareStatement(""
            										+ "SELECT MAX(id) FROM user"
            										+ "");
            selectByPage = connection.prepareStatement(""
					+ "SELECT * FROM user OFFSET ? LIMIT ?"
					+ "");		
            count = connection.prepareStatement(""
					+ "SELECT COUNT(*) FROM user"
					+ "");


			delete = connection.prepareStatement(""
					+ "DELETE FROM user WHERE id=?");
			
			update = connection.prepareStatement(""
					+ "UPDATE user SET (login, password, status)=(?,?,?) WHERE id=?");
			
            ResultSet rs = connection.getMetaData().getTables(null,null,null,null);

            while(rs.next()){
                if (rs.getString("TABLE_NAME").equalsIgnoreCase("user")){
                    tableExists = true;
                    break;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
public void delete(User user){
		
		try {
			delete.setInt(1, user.getId());
			delete.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update(User user){
		
		try {
			
			update.setString(1, user.getLogin());
			update.setString(2, user.getPassword());
			update.setBoolean(3, user.isStatus());
			update.setInt(4, user.getId());
			update.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
   

    public User getByLogin(String login){
        User user = null;

        try {
            selectByLogin.setString(1, login);
            ResultSet rs = selectByLogin.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setStatus(rs.getBoolean("status"));

            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return user;
    }

    public User getById(int id){
        User user = null;

        try {
            selectById.setInt(1, id);
            ResultSet rs = selectById.executeQuery();
            while(rs.next()){
                user= new User();
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setStatus(rs.getBoolean("status"));
                user.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
    
    public List<User> getPage(int offset, int limit){
		
		List<User> result = new ArrayList<User>();
		try {
			selectByPage.setInt(1, offset);
			selectByPage.setInt(2, limit);
			ResultSet rs = selectByPage.executeQuery();
			while(rs.next()){
				User a = new User();
				a.setId(rs.getInt("id"));
				a.setLogin(rs.getString("login"));
				a.setPassword(rs.getString("password"));
				a.setStatus(rs.getBoolean("status"));
				result.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
    
    public User get(int id){
		User user = null;
				
		try {
			selectById.setInt(1, id);
			ResultSet rs = selectById.executeQuery();
			while(rs.next()){
				user = new User();
				user.setLogin(rs.getString("login"));
				user.setPassword(rs.getString("password"));
				user.setStatus(rs.getBoolean("status"));
				user.setId(rs.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
				
		return user;
		
	}

    public void add(User user){

        try {
            insert.setString(1, user.getLogin());
            insert.setString(2, user.getPassword());
            insert.setBoolean(3, user.isStatus());
            insert.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createTable(){
        String createTableSql = "CREATE TABLE user("
                +"id bigint GENERATED BY DEFAULT AS IDENTITY,"
                +"login VARCHAR(20) NOT NULL,"
                +"password VARCHAR(20) NOT NULL,"
                +"status bit NOT NULL"
                +")";

        try {
            Statement createTable = _connection.createStatement();
            if(!tableExists){
                createTable.executeUpdate(createTableSql);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}