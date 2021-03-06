package de.jko.icoquet.service.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.jko.icoquet.dao.AuthenticationDAO;
import de.jko.icoquet.service.data.User;

@Path("authenticate")
public class AuthenticationService extends AbstractService
{
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response authenticate(@FormParam("username") String username, @FormParam("password") String password)
	{
		logger.info("Authenticating user " + username);
		
		AuthenticationDAO dao = new AuthenticationDAO();
		User user = dao.authenticateUser(username, password);
		
		logger.info("User '" + username + "' authenticated: " + user.toString());
		
		return Response.ok().entity(user).build();
	}
}
