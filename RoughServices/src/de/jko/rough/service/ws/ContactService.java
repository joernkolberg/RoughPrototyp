package de.jko.rough.service.ws;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.jko.rough.service.data.Contact;

@ApplicationPath("/resources")
@Path("contact")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ContactService extends Application
{
//	@POST
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@Produces({ MediaType.APPLICATION_JSON })
//	public Response insertContact(@FormParam("contactId") int contactId, @FormParam("firstName") String firstName,
//			@FormParam("lastName") String lastName, @FormParam("email") String email)
//	{
//		Contact contact = new Contact();
//		contact.setContactId(contactId);
//		contact.setFirstName(firstName);
//		contact.setLastName(lastName);
//		contact.setEmail(email);
//		
//				
//		System.out.println(contact.toString());
//		
//		return Response.ok().entity(contact).header("Access-Control-Allow-Origin", "http://localhost:8000").build();
//	}

//	@POST
//    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//	public Response insertContact(Contact contact)
//	{
//
//		System.out.println(contact.toString());
//		return Response.ok().entity(contact).header("Access-Control-Allow-Origin", "http://localhost:8000").build();
//	}
	
	
	@POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Contact insertContact(Contact contact)
	{

		System.out.println(contact.toString());
		return contact;
	}
	
	
	
	
	
	
	
	
	
	
	// @PUT
	// @Path("/{contactId}")
	// @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	// @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	// public Contact updateContact(@PathParam("contactId") int contactId,
	// @FormParam("firstName") String firstName,
	// @FormParam("lastName") String lastName,
	// @FormParam("email") String email) {
	// logger.debug("Entering ContactService.update() contactId" + contactId);
	//
	// EntityManager entityManager = entityManagerFactory.createEntityManager();
	// Contact contact = new Contact();
	// contact.setContactId(contactId);
	// contact.setFirstName(firstName);
	// contact.setLastName(lastName);
	// contact.setEmail(email);
	// try{
	// entityManager.getTransaction().begin();
	// entityManager.merge(contact);
	// entityManager.getTransaction().commit();
	// }catch(Throwable t){
	// if(entityManager.getTransaction().isActive())
	// entityManager.getTransaction().rollback();
	// contact = null;
	// }finally{
	// entityManager.close();
	// }
	// logger.debug("Exiting ContactService.updateContact()");
	//
	// return contact;
	// }
	//
	// @DELETE
	// @Path("/{contactId}")
	//
	// public void deleteContact(@PathParam("contactId") int contactId) {
	// logger.debug("Entering ContactService.deleteContact() contactId " +
	// contactId);
	// EntityManager entityManager = entityManagerFactory.createEntityManager();
	// try{
	// entityManager.getTransaction().begin();
	// Contact contact = entityManager.find(Contact.class, contactId);
	// logger.debug("remove contact " + contact);
	// entityManager.remove(contact);
	// logger.debug("After removing " + contact);
	// entityManager.getTransaction().commit();
	// }catch(Throwable t){
	// if(entityManager.getTransaction().isActive())
	// entityManager.getTransaction().rollback();
	//
	// }finally{
	// entityManager.close();
	// }
	// logger.debug("Exiting ContactService.deleteContact()");
	// }

}