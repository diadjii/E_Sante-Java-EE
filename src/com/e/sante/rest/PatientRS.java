package com.e.sante.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.e.sante.bean.Patient;
import com.e.sante.ejb.PatientService;

@Path("patient")
public class PatientRS {

	@EJB
	PatientService servicePatient;

	@GET	
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response findPatient(@PathParam("id") Long id) {
		Patient patient = servicePatient.findById(id);
		return Response.ok(patient).build();
	}
}
