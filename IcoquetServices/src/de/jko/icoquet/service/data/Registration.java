package de.jko.icoquet.service.data;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Registration implements Serializable
{
	private static final long serialVersionUID = 8580391120562900331L;

	private String username = null;
	private String email = null;
	private String password = null;
	private String password2 = null;
	
	public Registration()
	{
		super();
	}

	public Registration(String username, String email, String password, String password2)
	{
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.password2 = password2;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
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

	public String getPassword2()
	{
		return password2;
	}

	public void setPassword2(String password2)
	{
		this.password2 = password2;
	}

	@Override
	public String toString()
	{
		return "Registration [username=" + username + ", email=" + email + ", password=" + password + ", password2=" + password2 + "]";
	}

	
}
