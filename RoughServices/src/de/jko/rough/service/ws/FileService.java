package de.jko.rough.service.ws;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/upload")
public class FileService extends AbstractService
{
	@POST
	@Path("/file")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(  @FormDataParam("attachment") InputStream fileInputStream,
            @FormDataParam("attachment") FormDataContentDisposition fileMetaData) 
	{
		String uploadedFileLocation = "d://uploaded/" + fileMetaData.getFileName();
		writeToFile(fileInputStream, uploadedFileLocation);
		String output = "File uploaded to : " + uploadedFileLocation;
		System.out.println(output);

		return Response.status(200).build();

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
