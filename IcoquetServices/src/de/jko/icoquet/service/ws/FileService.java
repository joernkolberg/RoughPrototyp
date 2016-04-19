package de.jko.icoquet.service.ws;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import de.jko.icoquet.dao.RegisterDAO;

@Path("/upload")
public class FileService extends AbstractService
{
	@POST
	@Path("/file")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(  @FormDataParam("profilepic") InputStream fileInputStream,
            @FormDataParam("profilepic") FormDataContentDisposition fileMetaData, @FormDataParam("userid") String userid)
	{
		RegisterDAO dao = new RegisterDAO();
		dao.updateProfilePicture(Integer.parseInt(userid), getProfilePictureAsByteArray(fileInputStream));
		return Response.status(200).build();

	}
	
	@GET
	@Path("/picture")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response getProfilePicture(@Context UriInfo info)
	{
		String userid = info.getQueryParameters().getFirst("userid");
		System.out.println("userid = " + userid);
		RegisterDAO dao = new RegisterDAO();
		byte[] data = dao.getProfilePicture(Integer.parseInt(userid));
		return Response.ok(data, MediaType.APPLICATION_OCTET_STREAM)
                .header("content-disposition", "attachment; filename = profilepic.jpg").build();
	}

	private byte[] getProfilePictureAsByteArray(InputStream uploadedInputStream)
	{
		ByteArrayOutputStream out = null;
		try
		{
			out = new ByteArrayOutputStream();
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = uploadedInputStream.read(bytes)) != -1)
			{
				out.write(bytes, 0, read);
			}
			
		}
		catch (IOException e)
		{

			e.printStackTrace();
		}
		finally
		{
			try
			{
				out.close();
				uploadedInputStream.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return out.toByteArray();
	}
	
	// save uploaded file to new location
	private void writeToFile(InputStream uploadedInputStream, String uploadedFileLocation)
	{
		OutputStream out = null;
		try
		{
			out = new FileOutputStream(new File(uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = uploadedInputStream.read(bytes)) != -1)
			{
				out.write(bytes, 0, read);
			}
			
		}
		catch (IOException e)
		{

			e.printStackTrace();
		}
		finally
		{
			try
			{
				out.close();
				uploadedInputStream.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
