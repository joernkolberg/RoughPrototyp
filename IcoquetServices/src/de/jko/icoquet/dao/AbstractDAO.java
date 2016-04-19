package de.jko.icoquet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class AbstractDAO
{
	protected Logger logger = Logger.getLogger(this.getClass());
	
	protected Connection getConnection()
	{
		Connection connection = null;
		
		try
		{
			Class.forName("org.postgresql.Driver");
			String USERNAME = System.getenv("OPENSHIFT_POSTGRESQL_DB_USERNAME");
			String PASSWORD = System.getenv("OPENSHIFT_POSTGRESQL_DB_PASSWORD");
			String DB_NAME = System.getenv("OPENSHIFT_APP_NAME");
			String URL = "jdbc:" + System.getenv("OPENSHIFT_POSTGRESQL_DB_URL") + "/" + DB_NAME;
			connection = DriverManager.getConnection("jdbc:postgresql://127.7.45.2:5432/icoquetservices", USERNAME , PASSWORD);
			// connection = DriverManager.getConnection("jdbc:postgresql://localhost:6969/mobiledb", "postgres", "postgres");
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
