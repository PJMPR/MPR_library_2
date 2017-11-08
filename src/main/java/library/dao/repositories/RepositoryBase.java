package library.dao.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class RepositoryBase {
	
	protected Connection _connection;
	protected boolean tableExists;
	protected PreparedStatement insert;
	protected PreparedStatement selectById;
	protected PreparedStatement lastId;
	protected PreparedStatement selectByPage;
	protected PreparedStatement selectByUser;
	protected PreparedStatement selectByMessageType;
	protected PreparedStatement count;
	protected PreparedStatement delete;
	protected PreparedStatement update;
	
	protected RepositoryBase(Connection connection){
		try {
			_connection = connection;
			initStatements(connection);
			checkIfTableExists(connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	private void checkIfTableExists(Connection connection) throws SQLException {
		ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
		
		while(rs.next()){
			if(rs.getString("TABLE_NAME").equalsIgnoreCase(getTableName())){
				tableExists = true;
				break;
			}
		}
	}


	private void initStatements(Connection connection) throws SQLException {
		insert = connection.prepareStatement(getInsertSql());
		
		selectById = connection.prepareStatement( "SELECT * FROM "+ getTableName()+ " WHERE id=?");
		
		lastId = connection.prepareStatement(""
				+ "SELECT MAX(id) FROM "
				+ getTableName());
		
		count = connection.prepareStatement(""
				+ "SELECT COUNT(*) FROM "
				+ getTableName());
		
		selectByPage = connection.prepareStatement(""
				+ "SELECT * FROM "
				+ getTableName()
				+ " OFFSET ? LIMIT ?"
				+ "");
		
		delete = connection.prepareStatement(""
				+ "DELETE FROM "
				+ getTableName()
				+ " WHERE id=?");
		
		update = connection.prepareStatement(getUpdateSql());
	}

	
	public int count(){
		
		try {
			ResultSet rs = count.executeQuery();
			while(rs.next())
				return rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int lastId(){
		
		try {
			ResultSet rs = lastId.executeQuery();
			while(rs.next())
				return rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	protected abstract String getTableName();
	protected abstract String getInsertSql();
	protected abstract String getUpdateSql();
}
