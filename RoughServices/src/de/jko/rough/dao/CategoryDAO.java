package de.jko.rough.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends AbstractDAO
{
	public List<String> selectCategories()
	{
		List<String> categories = new ArrayList<String>();
		
		String sql = "select distinct category from categories";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try
		{
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();
			
			while(result.next())
				categories.add(result.getString(1));
			
			categories.remove("gender");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			cleanUp(result, statement, connection);
			System.out.println("User ");
		}
		
		return categories;
	}
}
