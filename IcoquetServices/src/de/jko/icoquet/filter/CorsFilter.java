package de.jko.icoquet.filter;

import java.io.IOException;
import java.net.URL;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.xml.DOMConfigurator;

import com.sun.istack.internal.logging.Logger;

/**
 * Servlet Filter implementation class CorsFilter
 */
@WebFilter("/*")
public class CorsFilter implements Filter
{
	private Logger logger = Logger.getLogger(CorsFilter.class);
	
	/**
	 * Default constructor.
	 */
	public CorsFilter()
	{
		logger.info("CorsFilter created");
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy()
	{
		logger.info("CorsFilter destroyed");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		logger.info("doFilter START");
		((HttpServletResponse) response).addHeader("Access-Control-Allow-Origin", "*");
		chain.doFilter(request, response);
		logger.info("doFilter END");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException
	{
		logger.info("CorsFilter.init");
	}
}
