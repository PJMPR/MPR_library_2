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

import library.dao.repositories.IBookRepository;
import library.dao.repositories.IRepository;
import library.dao.repositories.impl.HsqlCatalogFactory;
import library.domain.Book;
import library.domain.Book;
import library.domain.Book;
import library.domain.Book;
 
 
@Path("/books")
@Stateless
public class BooksResources {
	@PersistenceContext
	EntityManager mgr;
	
    IBookRepository _books;
   
    public BooksResources() {
//        _books = new HsqlCatalogFactory().library().books();
    }
   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@QueryParam("page") int page,@QueryParam("max") int max){
		List<Book> books = mgr
				.createNamedQuery("authors.all", Book.class)
				.getResultList();
		if(books.isEmpty())
			return Response.status(404).build();
		return Response.ok(new GenericEntity<List<Book>>(books){}).build();
    }  
   
 
    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response get(@PathParam("id") int id){
		List<Book> books = mgr.createNamedQuery("books.id",Book.class)
				.setParameter("id", id)
				.getResultList();
		if(books.size()==0)
			return Response.status(404).build();
		mgr.remove(books.get(0));
		return Response.noContent().build();
    }
    
    @POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addBook(Book book){
		mgr.persist(book);
		return Response.ok().build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response updateBook(@PathParam("id") int id ,Book book){
		List<Book> books = mgr.createNamedQuery("books.id",Book.class)
				.setParameter("id", id)
				.getResultList();
		if(books.size()==0)
			return Response.status(404).build();
		Book b = books.get(0);
		b.setTitle(book.getTitle());
		//..
		
		mgr.persist(b);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteBook(@PathParam("id") int id){
		List<Book> books = mgr.createNamedQuery("users.id",Book.class)
				.setParameter("id", id)
				.getResultList();
		if(books.size()==0)
			return Response.status(404).build();
		mgr.remove(books.get(0));
		return Response.noContent().build();
	}
   
    @GET
    @Path("/status")
    @Produces(MediaType.TEXT_HTML)
    public String test(){
        return "OK";
    }
   
}