package de.jko.rough.service.ws;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationPath("/resources")
@Path("authenticate")
public class AuthenticationService extends Application
{
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response authenticate(@FormParam("email") String email, @FormParam("password") String password)
	{
		System.out.println("User " + email +" authenticated");
		return Response.ok().build();
	}
}
