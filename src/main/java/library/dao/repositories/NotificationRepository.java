package library.dao.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import library.domain.IHaveId;
import library.domain.Notification;

public class NotificationRepository extends RepositoryBase<Notification>{
	
	public NotificationRepository(Connection connection){
		super(connection);
	}
	
	@Override
	protected String createTableSql() {
		return "CREATE TABLE notification("
				+ "id bigint GENERATED BY DEFAULT AS IDENTITY,"
				+ "message VARCHAR(64),"
				+ "notificationtype VARCHAR(16)"
				+ ")";
	}
	
	@Override
	protected String getTableName() {
		return "notification";
	}
	
	@Override
	protected String getUpdateSql() {
		return "UPDATE notification SET (message, notifiaction_type)=(?,?) WHERE id=?";
	}
	
	@Override
	protected String getInsertSql() {
		return "INSERT INTO notification(message,notification_type) VALUES(?,?)";
	}
	
	@Override
	protected void setInsert(Notification notification) throws SQLException {
		insert.setString(1, notification.getMessage());
		insert.setString(2, notification.getNotification_type());
	}
	
	protected void setUpdate(Notification notification) throws SQLException {
		update.setString(1, notification.getMessage());
		update.setString(2, notification.getNotification_type());
		update.setInt(3, notification.getId());
	}


public List<Notification> getPage(int offset, int limit){
	
	List<Notification> result = new ArrayList<Notification>();
	try {
		selectByPage.setInt(1, offset);
		selectByPage.setInt(2, limit);
		ResultSet rs = selectByPage.executeQuery();
		while(rs.next()){
			Notification a = new Notification();
			a.setId(rs.getInt("id"));
			a.setMessage(rs.getString("message"));
			a.setNotification_type(rs.getString("notification_type"));
			result.add(a);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return result;
}

public Notification get(int id){
	Notification notification = null;
			
	try {
		selectById.setInt(1, id);
		ResultSet rs = selectById.executeQuery();
		while(rs.next()){
			notification=new Notification();
			notification.setMessage(rs.getString("message"));
			notification.setNotification_type(rs.getString("notification_type"));
			notification.setId(rs.getInt("id"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}		
			
	return notification;
	
}

public void add(Notification notification){
	
	try {
		insert.setString(1, notification.getMessage());
		insert.setString(2, notification.getNotification_type());
		insert.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}
}
