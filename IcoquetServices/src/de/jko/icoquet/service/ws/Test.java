package de.jko.icoquet.service.ws;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.jko.icoquet.service.data.Attribute;

public class Test
{

	public static void main(String[] args)
	{
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			Attribute a = mapper.readValue("{\"name\": \"gender\", \"value\": \"r\", \"weighted\": \"false\"}", Attribute.class);
			System.out.println(a.toString());
			
			// List<Attribute> list = mapper.readValue("[{\"name\": \"gender\", \"value\": \"r\", \"weighted\": \"false\"}, {\"name\": \"gender\", \"value\": \"r\", \"weighted\": \"false\"}]", new TypeReference<List<Attribute>>(){});
			List<Attribute> list = mapper.readValue("[{\"name\": \"gender\", \"value\": \"r\", \"weighted\": \"false\"}, {\"name\": \"drink\", \"value\": \"r\", \"weighted\": false}, {\"name\": \"dinner\", \"value\": \"o\", \"weighted\": false}, {\"name\": \"pet\", \"value\": \"r\", \"weighted\": false}, {\"name\": \"plant\", \"value\": \"r\", \"weighted\": false}]\"", new TypeReference<List<Attribute>>(){});
			System.out.println(list.size());
		}
		catch (JsonParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (JsonMappingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
