package de.jko.rough.service.data;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Registration implements Serializable
{
	private static final long serialVersionUID = 8580391120562900331L;

	private String firstname = null;
	private String lastname = null;
	private String email = null;
	private String password = null;
	
	public Registration()
	{
		super();
	}

	public Registration(String firstname, String lastname, String email, String password)
	{
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}
	
	public String getFirstname()
	{
		return firstname;
	}
	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}
	public String getLastname()
	{
		return lastname;
	}
	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	public String toString()
	{
		return "Registration [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", password=" + password + "]";
	}
}
