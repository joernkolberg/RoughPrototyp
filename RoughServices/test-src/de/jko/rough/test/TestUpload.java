package de.jko.rough.test;

import java.io.File;
import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

public class TestUpload
{
	public static void main(String[] args)
	{
		try
		{

			Client client = ClientBuilder.newBuilder().register(MultiPartFeature.class).build();
			WebTarget webTarget = client.target(getBaseURI()).path("upload").path("pdf");
			
			final FileDataBodyPart filePart = new FileDataBodyPart("attachment", new File("D:/Downloads/alaska.jpg"));
		    FormDataMultiPart formDataMultiPart = new FormDataMultiPart();
		    final FormDataMultiPart multipart = (FormDataMultiPart) formDataMultiPart.field("foo", "bar").bodyPart(filePart);
		      
		    final WebTarget target = client.target(getBaseURI());
		    final Response response = target.request().post(Entity.entity(multipart, multipart.getMediaType()));

			System.out.println(response.getStatus() + " " + response.getStatusInfo() + " " + response);
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
	}

	private static URI getBaseURI()
	{
		return UriBuilder.fromUri("http://localhost:8080/RoughServices/rest/upload/file").build();
	}
}
