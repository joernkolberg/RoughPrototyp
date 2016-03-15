package de.jko.icoquet.service.data;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User implements Serializable
{
	private static final long serialVersionUID = 8580391120562900331L;

	private int id = -1;
	private String username = null;
	private String email = null;
	private String password = null;
	private String password2 = null;
	private Attributes attributes = new Attributes();
	
	public User()
	{
		super();
	}
	
	public User(int id, String username, String email)
	{
		super();
		this.id = id;
		this.username = username;
		this.email = email;
	}

	public User(String username, String email, String password, String password2)
	{
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.password2 = password2;
	}

	public User(int id, String username, String email, String password, String password2)
	{
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.password2 = password2;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
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

	public Attributes getAttributes()
	{
		return attributes;
	}

	public void setAttributes(Attributes attributes)
	{
		this.attributes = attributes;
	}

	@Override
	public String toString()
	{
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", attributes=" + attributes.toString() + "]";
	}
}
