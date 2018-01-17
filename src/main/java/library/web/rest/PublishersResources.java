
package library.web.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import library.domain.Publisher;

@Path("/Publishers")
@Stateless
public class PublishersResources{

	
	@PersistenceContext
	EntityManager mgr;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll(@QueryParam("page") int page,@QueryParam("max") int max){
		
		List<Publisher> Publishers = mgr
				.createNamedQuery("publishers.all", Publisher.class)
				.getResultList();
		if(Publishers.isEmpty())
			return Response.status(404).build();
		return Response.ok(new GenericEntity<List<Publisher>>(Publishers){}).build();
	}	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response get(@PathParam("id") int id){
		List<Publisher> publishers = mgr
				.createNamedQuery("publishers.id", Publisher.class)
				.getResultList();
				
		if(publishers.size()==0)
			return Response.status(404).build();
		return Response.ok(publishers.get(0)).build();
	}
	
	@GET
	@Path("/status")
	public String test(){
		return "OK";
	} 
	
}
