package de.jko.icoquet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.jko.icoquet.service.data.Attribute;
import de.jko.icoquet.service.data.User;

public class AttributeDAO extends AbstractDAO
{
	public List<User> findMatches(List<Attribute> andAttributeList, List<Attribute> orAttributeList)
	{
		List<User> matches = new ArrayList<User>();
		
		StringBuffer sql =  new StringBuffer("select r.id, r.username, r.email from registration r INNER JOIN attributes a ON a.userid = r.id where ");
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
				sql.append(" OR ");
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
			
			index = 1;
			for (Attribute attribute : orAttributeList)
			{
				statement.setString(index, attribute.getValue());
				index++;
			}
			
			ResultSet result = statement.executeQuery();
			while(result.next())
			{
				matches.add(new User(result.getInt("ID"), result.getString("USERNAME"), result.getString("EMAIL")));
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
}
