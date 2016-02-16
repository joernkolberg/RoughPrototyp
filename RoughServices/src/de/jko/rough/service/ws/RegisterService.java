package de.jko.rough.service.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.jko.rough.service.data.Registration;

@Path("register")
public class RegisterService extends AbstractService
{
	private static int counter = 0;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String test()
	{
		logger.info("GET-TEST");
		return "{\"id\":" + ++counter +",\"name\":\"Jupp Zupp\"}";
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED})
	@Produces({ MediaType.APPLICATION_JSON })
	public Response register(@FormParam("firstname") String firstname, @FormParam("lastname") String lastname,
			@FormParam("email") String email, @FormParam("password") String password)
	{
		Registration registration = new Registration(firstname, lastname, email, password);
		logger.info("register: " + registration.toString());
		return Response.ok().entity(registration).build();
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON })
	public Response registerJson(Registration registration)
	{
		logger.info("registerJson: " + registration.toString());
		return Response.ok().entity(registration).build();
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_XML })
	public Response registerXML(Registration registration)
	{
		logger.info("registerXML: " + registration.toString());
		return Response.ok().entity(registration).build();
	}
}
