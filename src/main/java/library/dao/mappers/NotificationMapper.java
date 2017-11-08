package library.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import library.domain.Notification;

public class NotificationMapper implements IMapper<Notification>{

	public Notification map(ResultSet rs) throws SQLException {
		Notification n = new Notification();
		n.setId(rs.getInt("id"));
		n.setMessage(rs.getString("message"));
		n.setNotification_type(rs.getString("notificationtype"));
		return n;
	}
}
