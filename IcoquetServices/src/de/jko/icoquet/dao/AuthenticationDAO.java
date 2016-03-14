package de.jko.icoquet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.jko.icoquet.service.data.User;

public class AuthenticationDAO extends AbstractDAO
{
	public User authenticateUser(String username, String password)
	{
		User user = new User();
		String sql = "select * from registration where username = ? and password = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try
		{
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			result = statement.executeQuery();
			
			if(result.next())
			{
				user.setId(result.getInt("ID"));
				user.setEmail(result.getString("EMAIL"));
				user.setUsername(result.getString("USERNAME"));
			}
				
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			cleanUp(result, statement, connection);
		}
		return user;
	}
}	
