package de.jko.icoquet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.jko.icoquet.service.data.User;
import de.jko.icoquet.service.data.ResponseObject;

public class RegisterDAO extends AbstractDAO
{
	private static final ResponseObject OK_RESPONSE = new ResponseObject(0, "Registrierung war erfolgreich");
	
	public ResponseObject registerUser(User registration)
	{
		// 01. Benutzernamen prüfen
		boolean rc = checkUser(registration);
		if(!rc)
		{
			return new ResponseObject(-1, "Benutzername existiert bereits");
		}
		
		// 02. Emailadresse prüfen
		rc = checkEmail(registration);
		if(!rc)
		{
			return new ResponseObject(-1, "Emailadresse existiert bereits");
		}
		
		// 03. Benutzer registrieren
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
			
			rc = statement.execute();
			
			if(rc)
				logger.info("User '" + registration.getUsername() + "' registered.");
			else
				logger.error("User '" + registration.getUsername() + "' could NOT be registered.");
		}
		catch (SQLException e)
		{
			logger.error("Error during registration - User '" + registration.getUsername() + "' could NOT be registered.", e);
			return new ResponseObject(-2, "Fehler bei der Registrierung");
		}
		finally
		{
			cleanUp(null, statement, connection);
		}
		
		
		
		return OK_RESPONSE;
	}
	
	public boolean checkUser(User registration)
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
		return rc;
	}
	
	public boolean checkEmail(User registration)
	{
		boolean rc = true;
		String sql = "select email from registration where username = ?";
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
		return rc;
	}
}
