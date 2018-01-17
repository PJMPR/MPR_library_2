package library.web.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

	@PersistenceContext
	EntityManager mgr;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll(@QueryParam("page") int page,@QueryParam("max") int max){
		
		List<User> users = mgr
				.createNamedQuery("users.all", User.class)
				.getResultList();
		if(users.isEmpty())
			return Response.status(404).build();
		return Response.ok(new GenericEntity<List<User>>(users){}).build();
	}	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response get(@PathParam("id") int id){
		List<User> users = mgr.createNamedQuery("users.id",User.class)
				.setParameter("id", id)
				.getResultList();
		if(users.size()==0)
			return Response.status(404).build();
		return Response.ok(users.get(0)).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(User user){
		mgr.persist(user);
		return Response.ok().build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response updateUser(@PathParam("id") int id ,User user){
		List<User> users = mgr.createNamedQuery("users.id",User.class)
				.setParameter("id", id)
				.getResultList();
		if(users.size()==0)
			return Response.status(404).build();
		User u = users.get(0);
		u.setLogin(user.getLogin());
		u.setPassword(user.getPassword());
		//...
		
		mgr.persist(u);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteUser(@PathParam("id") int id){
		List<User> users = mgr.createNamedQuery("users.id",User.class)
				.setParameter("id", id)
				.getResultList();
		if(users.size()==0)
			return Response.status(404).build();
		mgr.remove(users.get(0));
		return Response.noContent().build();
	}
	
	@GET
	@Path("/status")
	@Produces(MediaType.TEXT_HTML)
	public String test(){
		return "OK";
	} 
	
}
