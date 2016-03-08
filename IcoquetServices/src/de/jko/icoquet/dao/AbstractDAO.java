package de.jko.icoquet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AbstractDAO
{
	protected Connection getConnection()
	{
		Connection connection = null;
		
		try
		{
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:6969/mobiledb", "postgres", "postgres");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return connection;
	}
	
	protected void cleanUp(ResultSet rs, Statement statement, Connection connection)
	{
		try
		{
			if(rs != null && !rs.isClosed())
				rs.close();
			
			if(statement != null && !statement.isClosed())
				statement.close();
			
			if(connection != null && !connection.isClosed())
				connection.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
