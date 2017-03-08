package com.qa.cinema.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cinema.service.TicketService;

/**
 * 
 * @author Phil
 * @author Omar
 * 
 */

@Path("/ticket")
public class TicketEndpoint {

	@Inject
	private TicketService service;
	
	@Path("/json")
	@GET
	@Produces({"application/json"})
	public String getUserTickets(String email) {
		return service.getUserTickets(email);
	}
	
	@Path("/json")
	@POST
	@Produces({"application/json"})
	public String createTicket(String ticket) {
		return service.createTicket(ticket);
	}
	
	@Path("/json")
	@PUT
	@Produces({"application/json"})
	public String updateTicket(Long ticketId, String newTicket) {
		return service.updateTicket(ticketId, newTicket);
	}
	
	@Path("/json")
	@DELETE
	@Produces({"application/json"})
	public String deleteTicket(Long ticketId) {
		return service.deleteTicket(ticketId);
	}
	
	@Path("/json/tickets/{showingID}")
	@GET
	@Produces({"application/json"})
	public String getAvailableTickets(@PathParam("showingID") Long showingId) {
		return service.getAvailableTickets(showingId);
	}
	
}