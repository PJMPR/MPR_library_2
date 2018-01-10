package library.web.rest;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import library.dao.repositories.INotificationRepository;
import library.dao.repositories.impl.HsqlCatalogFactory;
import library.domain.Notification;

@Path("/Notifications")
@Stateless
public class NotificationsResources {

	INotificationRepository _Notifications;
	
	public NotificationsResources() throws SQLException {
		_Notifications = new HsqlCatalogFactory().library().notifications();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll(@QueryParam("page") int page,@QueryParam("max") int max){
		
		List<Notification> Notifications = _Notifications.getPage(page, max);
		if(Notifications.isEmpty())
			return Response.status(404).build();
		return Response.ok(new GenericEntity<List<Notification>>(Notifications){}).build();
	}	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response get(@PathParam("id") int id){
		Notification Notification = _Notifications.get(id);
		if(Notification==null)
			return Response.status(404).build();
		return Response.ok(Notification).build();
	}
	
	@GET
	@Path("/status")
	@Produces(MediaType.TEXT_HTML)
	public String test(){
		return "OK";
	} 
	
}
