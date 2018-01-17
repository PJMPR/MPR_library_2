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

import library.domain.Profile;

@Path("/profiles")
@Stateless
public class ProfilesResources {
	
	@PersistenceContext
	EntityManager mgr;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll(@QueryParam("page") int page,@QueryParam("max") int max){
		
		List<Profile> profiles = mgr
				.createNamedQuery("profiles.all", Profile.class)
				.getResultList();
		if(profiles.isEmpty())
			return Response.status(404).build();
		return Response.ok(new GenericEntity<List<Profile>>(profiles){}).build();
	}	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response get(@PathParam("id") int id){
		List<Profile> profiles = mgr.createNamedQuery("profiles.id",Profile.class)
				.setParameter("id", id)
				.getResultList();
		if(profiles.size()==0)
			return Response.status(404).build();
		return Response.ok(profiles.get(0)).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProfile(Profile profile){
		mgr.persist(profile);
		return Response.ok().build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response updateUser(@PathParam("id") int id ,Profile profile){
		List<Profile> profiles = mgr.createNamedQuery("profiles.id",Profile.class)
				.setParameter("id", id)
				.getResultList();
		if(profiles.size()==0)
			return Response.status(404).build();
		Profile p = profiles.get(0);
		p.setName(profile.getName());
		p.setSurname(profile.getSurname());
		p.setPesel(profile.getPesel());
		p.setPhone(profile.getPhone());
		p.setMail(profile.getMail());
		//...
		
		mgr.persist(p);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteUser(@PathParam("id") int id){
		List<Profile> profiles = mgr.createNamedQuery("profiles.id",Profile.class)
				.setParameter("id", id)
				.getResultList();
		if(profiles.size()==0)
			return Response.status(404).build();
		mgr.remove(profiles.get(0));
		return Response.noContent().build();
	}
	
	@GET
	@Path("/status")
	@Produces(MediaType.TEXT_HTML)
	public String test(){
		return "OK";
	} 
	
}
