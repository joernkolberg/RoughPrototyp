package de.jko.icoquet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthenticationDAO extends AbstractDAO
{
	public boolean authenticateUser(String username, String password)
	{
		boolean rc = false;
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
				rc = true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			cleanUp(result, statement, connection);
		}
		return rc;
	}
}	
