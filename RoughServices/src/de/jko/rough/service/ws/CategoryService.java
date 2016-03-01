package de.jko.rough.service.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.jko.rough.dao.CategoryDAO;

@Path("categories")
public class CategoryService extends AbstractService
{
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listCatagories()
	{
		System.out.println("listCatagories");
		CategoryDAO dao = new CategoryDAO();
		List<String> categories = dao.selectCategories();
		return Response.ok().entity(categories).build();
	}
}	
