package library.web.rest;
 
import java.util.List;
 
import library.dao.repositories.IBookRepository;
import library.dao.repositories.impl.HsqlCatalogFactory;
import library.domain.Book;
 
 
@Path("/books")
@Stateless
public class BooksResources {
    IBookRepository _books;
   
    public BooksResources() {
        _books = new HsqlCatalogFactory().library().books();
    }
   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@QueryParam("page") int page,@QueryParam("max") int max){
       
        List<Book> books = books.getPage(page, max);
        if(books.isEmpty())
            return Response.status(404).build();
        return Response.ok(new GenericEntity<List<Book>>(books){}).build();
    }  
   
 
    @GET  m
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response get(@PathParam("id") int id){
        Book book = _books.get(id);
        if(book==null)
            return Response.status(404).build();
        return Response.ok(book).build();
    }
   
    @GET
    @Path("/status")
    @Produces(MediaType.TEXT_HTML)
    public String test(){
        return "OK";
    }
   
}