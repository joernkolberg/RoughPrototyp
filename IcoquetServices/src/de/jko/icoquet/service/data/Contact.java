package de.jko.icoquet.service.data;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Contact implements Serializable
{
	private static final long serialVersionUID = -6450612666186449991L;

	private int contactId;
	private String firstName;
	private String lastName;
	private String email;
	
	public Contact()
	{
	}
	
	public Contact(int contactId, String firstName, String lastName, String email)
	{
		super();
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public int getContactId()
	{
		return contactId;
	}
	public void setContactId(int contactId)
	{
		this.contactId = contactId;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	@Override
	public String toString()
	{
		return "Contact [contactId=" + contactId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
}
