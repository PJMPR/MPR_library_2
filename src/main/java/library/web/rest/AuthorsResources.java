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

import library.domain.Author;
@Path("/authors")
@Stateless
public class AuthorsResources {
	@PersistenceContext
	EntityManager mgr;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll(@QueryParam("page") int page,@QueryParam("max") int max){
		
		List<Author> authors = mgr
				.createNamedQuery("authors.all", Author.class)
				.getResultList();
		if(authors.isEmpty())
			return Response.status(404).build();
		return Response.ok(new GenericEntity<List<Author>>(authors){}).build();
	}	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response get(@PathParam("id") int id){
		List<Author> authors = mgr.createNamedQuery("authors.id",Author.class)
				.setParameter("id", id)
				.getResultList();
		if(authors.size()==0)
			return Response.status(404).build();
		return Response.ok(authors.get(0)).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addAuthor(Author author){
		mgr.persist(author);
		return Response.ok().build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response updateAuthor(@PathParam("id") int id ,Author author){
		List<Author> authors = mgr.createNamedQuery("authors.id",Author.class)
				.setParameter("id", id)
				.getResultList();
		if(authors.size()==0)
			return Response.status(404).build();
		Author a = authors.get(0);
		a.setName(author.getName());
		a.setSurname(author.getSurname());
		a.setSecondName(author.getSecondName());
		
		mgr.persist(a);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteAuthor(@PathParam("id") int id){
		List<Author> authors = mgr.createNamedQuery("users.id",Author.class)
				.setParameter("id", id)
				.getResultList();
		if(authors.size()==0)
			return Response.status(404).build();
		mgr.remove(authors.get(0));
		return Response.noContent().build();
	}
	
	@GET
	@Path("/status")
	@Produces(MediaType.TEXT_HTML)
	public String test(){
		return "OK";
	} 
}
