package de.jko.icoquet.service.ws;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.jko.icoquet.dao.AttributeDAO;
import de.jko.icoquet.service.data.Attribute;
import de.jko.icoquet.service.data.User;

@Path("attributes")
public class AttributeService extends AbstractService
{

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("save")
	public Response saveAttributes(String attributes)
	{
		logger.info("attributes " + attributes);
		List<Attribute> attributeList = new ArrayList<Attribute>();
		
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(attributes);
			// JsonNode p = node;
			JsonNode p = node.get("attributes");
			String userid = "";
			
			List<Attribute> list = mapper.readValue(p.toString(), mapper.getTypeFactory().constructCollectionType(ArrayList.class, Attribute.class));
			for (Attribute attribute : list)
			{
				if(attribute.getName().equals("userid"))
					userid = attribute.getValue();
				else
					attributeList.add(attribute);
			}
			logger.info("attributeList size: " + attributeList.size());
			
			AttributeDAO dao = new AttributeDAO();
			dao.saveProfile(userid, attributeList);
		}
		catch (JsonParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (JsonMappingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return Response.ok().entity(true).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("read")
	public Response readAttributes(String attributes)
	{
		logger.info("attributes " + attributes);
		List<Attribute> andAttributeList = new ArrayList<Attribute>();
		List<Attribute> orAttributeList = new ArrayList<Attribute>();
		
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(attributes);
			// JsonNode p = node;
			JsonNode p = node.get("attributes");
			
			List<Attribute> list = mapper.readValue(p.toString(), mapper.getTypeFactory().constructCollectionType(ArrayList.class, Attribute.class));
			for (Attribute attribute : list)
			{
				if(attribute.isWeighted() || attribute.getName().equals("gender"))
					andAttributeList.add(attribute);
				else
					orAttributeList.add(attribute);
			}

			logger.info("andAttributeList size: " + andAttributeList.size());
			logger.info("orAttributeList size: " + orAttributeList.size());
			
			AttributeDAO dao = new AttributeDAO();
			List<User> matches = dao.findMatches(andAttributeList, orAttributeList);
			logger.info("matches: " + matches.size());
			
			// TODO: Gegensatz finden
			
			return Response.ok().entity(matches).build();
		}
		catch (JsonParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (JsonMappingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return Response.ok().entity("error").build();
	}
}
