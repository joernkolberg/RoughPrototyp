package de.jko.icoquet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.jko.icoquet.service.data.Registration;
import de.jko.icoquet.service.data.ResponseObject;

public class RegisterDAO extends AbstractDAO
{
	private static final ResponseObject OK_RESPONSE = new ResponseObject(0, "Registrierung war erfolgreich");
	
	public ResponseObject registerUser(Registration registration)
	{
		boolean rc = checkUser(registration);
		if(!rc)
		{
			return new ResponseObject(-1, "Benutzername existiert bereits");
		}
			
		String sql = "insert into registration (username, email, password) values(?, ?, ?)";
		Connection connection = null;
		PreparedStatement statement = null;
				
		try
		{
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, registration.getUsername());
			statement.setString(2, registration.getEmail());
			statement.setString(3, registration.getPassword());
			statement.execute();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			
			return new ResponseObject(-2, "Fehler bei der Registrierung");
		}
		finally
		{
			cleanUp(null, statement, connection);
		}
		
		logger.info("User '" + registration.getUsername() + "' registered.");
		
		return OK_RESPONSE;
	}
	
	public boolean checkUser(Registration registration)
	{
		boolean rc = true;
		String sql = "select username from registration where username = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try
		{
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, registration.getUsername());
			result = statement.executeQuery();
			
			if(result.next())
				rc = false;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			cleanUp(result, statement, connection);
		}
		logger.info("User '" + registration.getUsername() + "' not yet registered: " + rc);
		return rc;
	}
}
