package de.jko.icoquet.service.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.jko.icoquet.dao.CategoryDAO;

@Path("categories")
public class CategoryService extends AbstractService
{
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listCatagories()
	{
		logger.info("listCatagories - START");
		
		CategoryDAO dao = new CategoryDAO();
		List<String> categories = dao.selectCategories();
		
		logger.info("listCatagories: " + categories.size());
		logger.info("listCatagories - END");
		
		return Response.ok().entity(categories).build();
	}
}	
