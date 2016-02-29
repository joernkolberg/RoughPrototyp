package de.jko.rough.service.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("authenticate")
public class AuthenticationService extends AbstractService
{
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response authenticate(@FormParam("username") String username, @FormParam("password") String password)
	{
		logger.info("User " + username +" authenticated");
		// TODO: Prüfung
		return Response.ok().build();
	}
}
