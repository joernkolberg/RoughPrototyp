package de.jko.rough.dao.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.jko.icoquet.dao.AttributeDAO;
import de.jko.icoquet.service.data.Attribute;
import de.jko.icoquet.service.data.User;

public class TestAttributesDAO
{
	@Test
	public void testSearch()
	{
		AttributeDAO dao = new AttributeDAO();
		List<Attribute> andAttributeList = new ArrayList<Attribute>();
		andAttributeList.add(new Attribute("gender", "r"));
		
		List<Attribute> orAttributeList = new ArrayList<Attribute>();
		andAttributeList.add(new Attribute("food", "o"));
		andAttributeList.add(new Attribute("drink", "o"));
		andAttributeList.add(new Attribute("pet", "r"));
		
		List<User> users = dao.findMatches(andAttributeList, orAttributeList);
		
		for (User user : users)
		{
			System.out.println(user.toString());
		}
		
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			String jsonInString = mapper.writeValueAsString(users);
			System.out.println(jsonInString);
		}
		catch (JsonProcessingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	
