package library.dao.repositories;

import library.domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepository {

    Connection connection;
    private boolean tableexists;

    PreparedStatement insert;

    public UserRepository(){

        try {
            connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");

            insert = connection.prepareStatement(""
                                                    +"INSERT INTO user(login,password,status)"
                                                    +"VALUES(?,?,?)");

            ResultSet rs = connection.getMetaData().getTables(null,null,null,null);

            while(rs.next()){
                if (rs.getString("TABLE_NAME").equalsIgnoreCase("user")){
                    tableexists = true;
                    break;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
                +"login VARCHAR(20) NOT NULL,"
                +"password VARCHAR(20) NOT NULL,"
                +"status bit NOT NULL"
                +")";

        try {
            Statement createTable = connection.createStatement();
            if(!tableexists){
                createTable.executeUpdate(createTableSql);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}