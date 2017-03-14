package com.qa.cinema.rest;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cinema.persistence.Ticket;
import com.qa.cinema.service.EmailService;
import com.qa.cinema.util.JSONUtil;

@Path("/email")
public class EmailEndpoint {

	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private EmailService emailSender;
	
	@Path("/json/{id}/")
	@GET
	@Produces({ "application/json" })
	public String sendEmail(@PathParam("id") Long ticketId) {
		Ticket ticketInDB = manager.find(Ticket.class, ticketId);
		
		if(ticketInDB != null) {
			return emailSender.sendOrderConfirmation(ticketInDB);
		}
		return "Ticket not found";
	}
}