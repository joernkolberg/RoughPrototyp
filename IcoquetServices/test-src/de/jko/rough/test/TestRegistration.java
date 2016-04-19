package de.jko.rough.test;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.junit.Test;

import de.jko.icoquet.service.data.User;

public class TestRegistration extends AbstractTest
{
	public TestRegistration()
	{
		super();
	}

	@Test
	public void testForm()
	{
		logger.info("testForm - START");
		
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget service = client.target(getBaseURI());
		
		Form form = new Form ();
		form.param("firstname", "Jupp");
		form.param("lastname", "Zupp");
		form.param("email", "jupp.zupp@yahoo.de");
		form.param("password", "secret");
		
		Entity<Form> entity = Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED);
		Response response = service.path("register").request(MediaType.APPLICATION_JSON).post(entity, Response.class);

		logger.info("testForm - response: " + response.getStatus());
		logger.info("testForm - END");
	}
	
	@Test
	public void testJson()
	{
		logger.info("testJson - START");
		
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget service = client.target(getBaseURI());
		
		User registration = new User("Jupp", "Zupp", "jupp.zupp@yahoo.de", "secret");
		
		Entity<User> entity = Entity.entity(registration, MediaType.APPLICATION_JSON_TYPE);
		Response response = service.path("register").request(MediaType.APPLICATION_JSON_TYPE).post(entity, Response.class);

		logger.info("testJson - response: " + response.getStatus());
		logger.info("testJson - END");
	}
	
	@Test
	public void testXML()
	{
		logger.info("testXML - START");
		
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget service = client.target(getBaseURI());
		
		User registration = new User("Jupp", "Zupp", "jupp.zupp@yahoo.de", "secret");
		
		Entity<User> entity = Entity.entity(registration, MediaType.APPLICATION_XML_TYPE);
		Response response = service.path("register").request(MediaType.APPLICATION_XML_TYPE).post(entity, Response.class);

		logger.info("testXML - response: " + response.getStatus());
		logger.info("testXML - END");
	}
}
