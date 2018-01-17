package library.web.rest;

import java.util.List;

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
import javax.ejb.Stateless;

import library.dao.repositories.IAdressRepository;
import library.dao.repositories.impl.HsqlCatalogFactory;
import library.domain.Address;
import library.domain.User;

@Path("/adresses")
@Stateless
public class AdressesResources {
	
	@PersistenceContext
	EntityManager mgr;
	
	/*IAdressRepository _addresses;
	
	public AdressesResources() {
//		_addresses = new HsqlCatalogFactory().library().addresses();
	}*/
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll(@QueryParam("page") int page,@QueryParam("max") int max){
		List<Address> addresses = mgr.createNamedQuery("adres.all", Address.class).getResultList();
		if(addresses.isEmpty())
			return Response.status(404).build();
		return Response.ok(new GenericEntity<List<Address>>(addresses){}).build();
	}	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response get(@PathParam("id") int id){
		List <Address> address = mgr.createNamedQuery("adres.all", Address.class).setParameter("id", id).getResultList();
		if(address.isEmpty())
			return Response.status(404).build();
		return Response.ok(address).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addAddress(Address address){
		mgr.persist(address);
		return Response.ok().build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response updateAddress(@PathParam("id") int id ,Address address){
		List<Address> addresses = mgr.createNamedQuery("adres.id",Address.class)
				.setParameter("id", id)
				.getResultList();
		if(addresses.size()==0)
			return Response.status(404).build();
		Address a = addresses.get(0);
		a.setCity(address.getCity());
		a.setPostalCode(address.getPostalCode());
		a.setStreet(address.getStreet());
		a.setApNumber(address.getApNumber());
		
		mgr.persist(a);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteAddress(@PathParam("id") int id){
		List<Address> addresses = mgr.createNamedQuery("adres.id",Address.class)
				.setParameter("id", id)
				.getResultList();
		if(addresses.size()==0)
			return Response.status(404).build();
		mgr.remove(addresses.get(0));
		return Response.noContent().build();
	}
	
	@GET
	@Path("/status")
	@Produces(MediaType.TEXT_HTML)
	public String test(){
		return "OK";
	} 
	
	
}
