package de.jko.icoquet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.jko.icoquet.service.data.Attribute;
import de.jko.icoquet.service.data.Attributes;
import de.jko.icoquet.service.data.User;

public class AttributeDAO extends AbstractDAO
{
	public List<User> findMatches(List<Attribute> andAttributeList, List<Attribute> orAttributeList)
	{
		List<User> matches = new ArrayList<User>();
		
		StringBuffer sql =  new StringBuffer("select r.id, r.username, r.email, "
				+ "a.acting, a.beard, a.design, a.dinner, a.drink, a.fastfood, a.food, a.freetime, a.gender, "
				+ "a.goingout, a.hair, a.music, a.pet, a.place, a.plant, a.season, a.sports, a.swimming "
				+ "from registration r INNER JOIN attributes a ON a.userid = r.id where ");
		Connection connection = null;
		PreparedStatement statement = null;
				
		try
		{
			int counter = 0;
			
			if(andAttributeList.size() > 0)
			{
				sql.append("(");
			}
			for (Attribute attribute : andAttributeList)
			{
				if(counter > 0)
					sql.append(" AND ");
				
				sql.append("a.");
				sql.append(attribute.getName());
				sql.append(" = ?");
				counter++;
			}
			if(andAttributeList.size() > 0)
			{
				sql.append(")");
			}
			
			if(andAttributeList.size() > 0 && orAttributeList.size() > 0)
			{
				sql.append(" AND ");
			}
			
			counter = 0;
			
			if(orAttributeList.size() > 0)
			{
				sql.append("(");
			}
			for (Attribute attribute : orAttributeList)
			{
				if(counter > 0)
					sql.append(" OR ");
				
				sql.append("a.");
				sql.append(attribute.getName());
				sql.append(" = ?");
				counter++;
			}
			if(orAttributeList.size() > 0)
			{
				sql.append(")");
			}
			
			logger.info(sql.toString());
			
			connection = getConnection();
			statement = connection.prepareStatement(sql.toString());
			int index = 1;
			for (Attribute attribute : andAttributeList)
			{
				statement.setString(index, attribute.getValue());
				index++;
			}
			
			for (Attribute attribute : orAttributeList)
			{
				statement.setString(index, attribute.getValue());
				index++;
			}
			
			ResultSet result = statement.executeQuery();
			while(result.next())
			{
				Attributes attributes = new Attributes();
				attributes.setActing(result.getString("ACTING"));
				attributes.setBeard(result.getString("BEARD"));
				attributes.setDesign(result.getString("DESIGN"));
				attributes.setDinner(result.getString("DINNER"));
				attributes.setDrink(result.getString("DRINK"));
				attributes.setFastfood(result.getString("FASTFOOD"));
				attributes.setFood(result.getString("FOOD"));
				attributes.setFreetime(result.getString("FREETIME"));
				attributes.setGender(result.getString("GENDER"));
				attributes.setGoingout(result.getString("GOINGOUT"));
				attributes.setHair(result.getString("HAIR"));
				attributes.setMusic(result.getString("MUSIC"));
				attributes.setPet(result.getString("PET"));
				attributes.setPlace(result.getString("PLACE"));
				attributes.setPlant(result.getString("PLANT"));
				attributes.setSeason(result.getString("SEASON"));
				attributes.setSports(result.getString("SPORTS"));
				attributes.setSwimming(result.getString("SWIMMING"));
				
				User user = new User(result.getInt("ID"), result.getString("USERNAME"), result.getString("EMAIL"));
				user.setAttributes(attributes);
				matches.add(user);
			}
		}
		catch (SQLException e)
		{
			logger.error("Error", e);
		}
		finally
		{
			cleanUp(null, statement, connection);
		}
		
		return matches;
	}
	
	public User selectMatch(int id)
	{
		User user = null;
		
		StringBuffer sql = new StringBuffer("select r.id, r.username, r.email from registration r where r.id = ?");
		
		Connection connection = null;
		PreparedStatement statement = null;
				
		try
		{
			
			connection = getConnection();
			statement = connection.prepareStatement(sql.toString());
			statement.setInt(1, id);
			
			ResultSet result = statement.executeQuery();
			if(result.next())
			{
				user = new User(result.getInt("ID"), result.getString("USERNAME"), result.getString("EMAIL"));
			}
		}
		catch (SQLException e)
		{
			logger.error("Error", e);
		}
		finally
		{
			cleanUp(null, statement, connection);
		}
		
		return user;
	}
	
}
