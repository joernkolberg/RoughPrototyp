package de.jko.icoquet.service.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.jko.icoquet.dao.RegisterDAO;
import de.jko.icoquet.service.data.User;
import de.jko.icoquet.service.data.ResponseObject;

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
	public Response register(@FormParam("username") String username, @FormParam("email") String email,
			@FormParam("password") String password, @FormParam("password2") String password2)
	{
		ResponseObject response = null;
		User registration = new User(username, email, password, password2);
		logger.info("register: " + registration.toString());
		
		
		RegisterDAO dao = new RegisterDAO();
		response = dao.registerUser(registration);
		
		return Response.ok().entity(response).build();
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON })
	public Response registerJson(User registration)
	{
		logger.info("registerJson: " + registration.toString());
		return Response.ok().entity(registration).build();
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_XML })
	public Response registerXML(User registration)
	{
		logger.info("registerXML: " + registration.toString());
		return Response.ok().entity(registration).build();
	}
	
	private void registerUser(User registration)
	{
		// 01 Username bereits vorhanden?
		// 02 Email bereits vorhanden?
		// 03 Passwörter identisch?
		// 04Passwörter stark genug?
	}
}
