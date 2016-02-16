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

public class TestRegistration
{

	public static void main(String[] args)
	{
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget service = client.target(getBaseURI());
		
		Form form = new Form ();
		form.param("firstname", "Jupp");
		form.param("lastname", "Zupp");
		form.param("email", "jupp.zupp@yahoo.de");
		form.param("password", "secret");
		
		Entity<Form> entity = Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED);
		Response response = service.path("register").request(MediaType.APPLICATION_JSON_TYPE).post(entity, Response.class);

		System.out.println(response.getStatus());
	}

	private static URI getBaseURI()
	{
		return UriBuilder.fromUri("http://localhost:8080/RoughServices/rest").build();
	}

}
