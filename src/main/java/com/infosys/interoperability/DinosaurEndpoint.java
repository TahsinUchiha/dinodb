package com.infosys.interoperability;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.infosys.business.service.DinosaurService;

@Path("/dinosaur")
public class DinosaurEndpoint {

	@Inject
	private DinosaurService service;

	@Path("/getAllDinosaurs")
	@GET
	@Produces({ "application/json" })
	public String getAllDinosaurs() {
		return service.getAllDinosaurs();
	}

	@Path("/addDinosaur")
	@POST
	@Produces({ "application/json" })
	public String createDinosaur(String dinosaur) {
		return service.createDinosaur(dinosaur);
	}

	@Path("/updateDinosaur/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateDinosaur(@PathParam("id") Long dinosaurid, String dinosaur) {
		return service.updateDinosaur(dinosaurid, dinosaur);
	}

	@Path("/deleteDinosaur/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteDinosaur(@PathParam("id") Long dinosaurid) {
		return service.deleteDinosaur(dinosaurid);
	}

	public void setService(DinosaurService service) {
		this.service = service;
	}

}
