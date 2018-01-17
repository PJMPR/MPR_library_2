package library.web.rest;

import java.util.List;

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
import library.dao.repositories.IDatabaseCatalog;
import library.dao.repositories.impl.HsqlCatalogFactory;
import library.domain.Address;

@Path("/adresses")
@Stateless
public class AdressesResources {
	IAdressRepository _addresses;
	IDatabaseCatalog _library;
	public AdressesResources() {
		_addresses = new HsqlCatalogFactory().library().addresses();
		_library = new HsqlCatalogFactory().library();
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
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addAddress(Address address){
		_addresses.add(address);
		_library.saveChanges();
		return Response.ok().build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response updateAddress(@PathParam("id") int id ,Address address){
		
		Address a = _addresses.get(id);
		if(a ==null)
			return Response.status(404).build();
		address.setId(id);
		_addresses.update(address);
		_library.saveChanges();
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteAddress(@PathParam("id") int id){
		Address a = _addresses.get(id);
		if(a==null)
			return Response.status(404).build();
		_addresses.delete(a);
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
