package library.web.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ejb.Stateless;

import library.dao.repositories.IAdressRepository;
import library.dao.repositories.impl.HsqlCatalogFactory;
import library.domain.Address;

@Path("/adresses")
@Stateless
public class AdressesResources {
	IAdressRepository _addresses;
	
	public AdressesResources() {
		_addresses = new HsqlCatalogFactory().library().addresses();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll(@QueryParam("page") int page,@QueryParam("max") int max){
		List<Address> addresses = _addresses.getPage(page, max);
		if(addresses.isEmpty())
			return Response.status(404).build();
		return Response.ok(new GenericEntity<List<Address>>(addresses){}).build();
	}	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response get(@PathParam("id") int id){
		Address address = _addresses.get(id);
		if(address==null)
			return Response.status(404).build();
		return Response.ok(address).build();
	}
}
