package library.dao.repositories.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import library.dao.mappers.IMapper;
import library.dao.repositories.INotificationRepository;
import library.domain.Author;
import library.domain.IHaveId;
import library.domain.Notification;
import library.domain.Publisher;

public class NotificationRepository extends RepositoryBase<Notification>
	implements INotificationRepository {
	
    private PreparedStatement selectByType;
	
	public NotificationRepository(Connection connection, IMapper<Notification> mapper) throws SQLException {
		super(connection, mapper);
		
		selectByType = connection.prepareStatement("SELECT * FROM notification WHERE notification_type = ?");
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
	
	@Override
	protected void setUpdate(Notification notification) throws SQLException {
		update.setString(1, notification.getMessage());
		update.setString(2, notification.getNotification_type());
		update.setInt(3, notification.getId());
	}

	public List<Notification> withType(String notification_type) {

		List<Notification> result = new ArrayList<Notification>();
		try {
			selectByType.setString(1, notification_type);
			ResultSet rs = selectByType.executeQuery();
			while(rs.next()){
				result.add(_mapper.map(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	

	
}