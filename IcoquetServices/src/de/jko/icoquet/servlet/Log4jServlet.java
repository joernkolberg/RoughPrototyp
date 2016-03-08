package de.jko.icoquet.servlet;

import java.net.URL;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Servlet implementation class Log4jServlet
 */
@WebServlet(name="Log4jServlet", urlPatterns="/Log4jServlet", loadOnStartup=1)
public class Log4jServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Log4jServlet()
	{
		super();
		URL configURL = this.getClass().getClassLoader().getResource("icoquet-log4j.xml");
		DOMConfigurator.configure(configURL);
		Logger.getLogger(this.getClass()).info("rough-log4j.xml initialized");
	}
}
