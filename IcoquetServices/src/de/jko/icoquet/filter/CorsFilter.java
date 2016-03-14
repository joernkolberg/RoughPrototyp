package de.jko.icoquet.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

/**
 * Servlet Filter implementation class CorsFilter
 */
@WebFilter("/*")
public class CorsFilter implements Filter
{
	private Logger logger = Logger.getLogger(this.getClass());
	
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
		MDC.put("request-id", UUID.randomUUID().toString());

		((HttpServletResponse) response).addHeader("Access-Control-Allow-Origin", "*");
		((HttpServletResponse) response).addHeader("Access-Control-Allow-Headers", "Content-Type");
		
		chain.doFilter(request, response);

		MDC.remove("request-id");
		
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
