package de.jko.rough.test;

import java.net.URI;
import java.net.URL;

import javax.ws.rs.core.UriBuilder;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class AbstractTest
{
	protected Logger logger = null;

	public AbstractTest()
	{
		super();
		URL configURL = this.getClass().getClassLoader().getResource("icoquet-log4j.xml");
		DOMConfigurator.configure(configURL);
		logger = Logger.getLogger(this.getClass());
	}
	
	protected static URI getBaseURI()
	{
		return UriBuilder.fromUri("http://localhost:8080/IcoquetServices/rest").build();
	}
}
