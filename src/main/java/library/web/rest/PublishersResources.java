
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

import library.dao.repositories.IPublisherRepository;
import library.dao.repositories.impl.HsqlCatalogFactory;
import library.domain.Publisher;

@Path("/Publishers")
@Stateless
public class PublishersResources{
	IPublisherRepository _Publishers;
	
	public PublishersResources() {
		_Publishers = new HsqlCatalogFactory().library().publishers();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll(@QueryParam("page") int page,@QueryParam("max") int max){
		
		List<Publisher> Publishers = _Publishers.getPage(page, max);
		if(Publishers.isEmpty())
			return Response.status(404).build();
		return Response.ok(new GenericEntity<List<Publisher>>(Publishers){}).build();
	}	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response get(@PathParam("id") int id){
		Publisher publisher = _Publishers.get(id);
		if(publisher==null)
			return Response.status(404).build();
		return Response.ok(publisher).build();
	}
	
	@GET
	@Path("/status")
	public String test(){
		return "OK";
	} 
	
}
