package library.web.rest;

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

import library.dao.repositories.IUserRepository;
import library.dao.repositories.impl.HsqlCatalogFactory;
import library.domain.User;

@Path("/users")
@Stateless
public class UsersResources {

	IUserRepository _users;
	
	public UsersResources() {
		_users = new HsqlCatalogFactory().library().users();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll(@QueryParam("page") int page,@QueryParam("max") int max){
		
		List<User> users = _users.getPage(page, max);
		if(users.isEmpty())
			return Response.status(404).build();
		return Response.ok(new GenericEntity<List<User>>(users){}).build();
	}	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response get(@PathParam("id") int id){
		User user = _users.get(id);
		if(user==null)
			return Response.status(404).build();
		return Response.ok(user).build();
	}
	
	@GET
	@Path("/status")
	@Produces(MediaType.TEXT_HTML)
	public String test(){
		return "OK";
	} 
	
}
