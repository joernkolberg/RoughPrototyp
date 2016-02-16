package de.jko.rough.test;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import de.jko.rough.service.data.Contact;

public class TestContact
{
	public static void main(String[] args)
	{
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget service = client.target(getBaseURI());
		
		Contact contact = new Contact(1111, "Jupp", "Zupp", "jupp.zupp@yahoo.de");
		Entity<Contact> entity = Entity.entity(contact, MediaType.APPLICATION_JSON);
		
		Response response = service.path("contact").request(MediaType.APPLICATION_JSON).post(entity, Response.class);
		System.out.println(response.getStatus());
	}

	private static URI getBaseURI()
	{
		return UriBuilder.fromUri("http://localhost:8080/RoughServices/rest").build();
	}
}
