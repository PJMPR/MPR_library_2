package library.web.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import library.dao.repositories.IDatabaseCatalog;
import library.dao.repositories.IUserRepository;
import library.dao.repositories.impl.HsqlCatalogFactory;
import library.domain.User;

@Path("/users")
@Stateless
public class UsersResources {

	IUserRepository _users;
	IDatabaseCatalog _library;
	public UsersResources() {
		_library = new HsqlCatalogFactory().library();
		_users = _library.users();
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
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(User user){
		_users.add(user);
		_library.saveChanges();
		return Response.ok().build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response updateUser(@PathParam("id") int id ,User user){
		
		User u = _users.get(id);
		if(u ==null)
			return Response.status(404).build();
		user.setId(id);
		_users.update(user);
		_library.saveChanges();
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteUser(@PathParam("id") int id){
		User u = _users.get(id);
		if(u==null)
			return Response.status(404).build();
		_users.delete(u);
		_library.saveChanges();
		return Response.noContent().build();
	}
	
	@GET
	@Path("/status")
	@Produces(MediaType.TEXT_HTML)
	public String test(){
		return "OK";
	} 
	
}
