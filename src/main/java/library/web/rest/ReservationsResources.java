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

import library.domain.ReservationOrder;

@Path("/reservations")
@Stateless
public class ReservationsResources {

	@PersistenceContext
	EntityManager mgr;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll(@QueryParam("page") int page,@QueryParam("max") int max){
		
		List<ReservationOrder> reservationOrders = mgr
				.createNamedQuery("reservationorders.all", ReservationOrder.class)
				.getResultList();
		if(reservationOrders.isEmpty())
			return Response.status(404).build();
		return Response.ok(new GenericEntity<List<ReservationOrder>>(reservationOrders){}).build();
	}	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response get(@PathParam("id") int id){
		List<ReservationOrder> reservationOrders = mgr.createNamedQuery("reservationorders.id",ReservationOrder.class)
				.setParameter("id", id)
				.getResultList();
		if(reservationOrders.size()==0)
			return Response.status(404).build();
		return Response.ok(reservationOrders.get(0)).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addReservationOrder(ReservationOrder reservationOrder){
		mgr.persist(reservationOrder);
		return Response.ok().build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response updateReservationOrder(@PathParam("id") int id ,ReservationOrder reservationOrder){
		List<ReservationOrder> reservationOrders = mgr.createNamedQuery("reservationorders.id",ReservationOrder.class)
				.setParameter("id", id)
				.getResultList();
		if(reservationOrders.size()==0)
			return Response.status(404).build();
		ReservationOrder r = reservationOrders.get(0);
		r.setBook(reservationOrder.getBook());
		r.setDate(reservationOrder.getDate());
		r.setUser(reservationOrder.getUser());
		
		mgr.persist(r);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteReservationOrder(@PathParam("id") int id){
		List<ReservationOrder> reservationOrders = mgr.createNamedQuery("reservationorders.id",ReservationOrder.class)
				.setParameter("id", id)
				.getResultList();
		if(reservationOrders.size()==0)
			return Response.status(404).build();
		mgr.remove(reservationOrders.get(0));
		return Response.noContent().build();
	}
	
	@GET
	@Path("/status")
	@Produces(MediaType.TEXT_HTML)
	public String test(){
		return "OK";
	} 
	
}
