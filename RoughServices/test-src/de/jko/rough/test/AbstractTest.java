package de.jko.rough.test;

import java.net.URL;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class AbstractTest
{
	protected Logger logger = null;

	public AbstractTest()
	{
		super();
		URL configURL = this.getClass().getClassLoader().getResource("rough-log4j.xml");
		DOMConfigurator.configure(configURL);
		logger = Logger.getLogger(this.getClass());
	}
}
