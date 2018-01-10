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

import library.dao.repositories.IAuthorRepository;
import library.dao.repositories.IDatabaseCatalog;
import library.dao.repositories.impl.HsqlCatalogFactory;
import library.domain.Author;
import library.domain.User;

@Path("/authors")
@Stateless
public class AuthorsResources {

	IAuthorRepository _authors;
	IDatabaseCatalog _library;
	
	public AuthorsResources() {
		_library = new HsqlCatalogFactory().library();
		_authors = _library.authors();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll(@QueryParam("page") int page,@QueryParam("max") int max){
		
		List<Author> authors = _authors.getPage(page, max);
		if(authors.isEmpty())
			return Response.status(404).build();
		return Response.ok(new GenericEntity<List<Author>>(authors){}).build();
	}	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response get(@PathParam("id") int id){
		Author author = _authors.get(id);
		if(author==null)
			return Response.status(404).build();
		return Response.ok(author).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(Author author){
		_authors.add(author);
		_library.saveChanges();
		return Response.ok().build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response updateUser(@PathParam("id") int id ,Author author){
		
		Author a = _authors.get(id);
		if(a == null)
			return Response.status(404).build();
		author.setId(id);
		_authors.update(author);
		_library.saveChanges();
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteUser(@PathParam("id") int id){
		Author a = _authors.get(id);
		if(a == null)
			return Response.status(404).build();
		_authors.delete(a);
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
