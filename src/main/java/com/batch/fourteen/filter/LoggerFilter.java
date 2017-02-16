package com.batch.fourteen.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import com.batch.fourteen.utils.SystemProperties;



/**
 * LoggerFilter is a custom Filter used to add parameters that can be used in logback.xml file.
 * We can then display in console or log file those parameters passed.
 * 
 * @author jangolluan
 * @since June 03, 2016
 */
public class LoggerFilter implements Filter {

	private final static Logger logger = Logger.getLogger(LoggerFilter.class);

	/**
	 * Called by the web container to indicate to a filter that it is being placed into service. 
	 * The servlet container calls the init method exactly once after instantiating the filter. 
	 * The init method must complete successfully before the filter is asked to do any filtering work
	 */
	@Override
	public void destroy() {
		
	}

	/**
	 * The doFilter method of the Filter is called by the container each time a request/response pair is 
	 * passed through the chain due to a client request for a resource at the end of the chain. 
	 * The FilterChain passed in to this method allows the Filter to pass on the request and response to the next entity in the chain.
	 */
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		try {
			HttpServletRequest request = (HttpServletRequest) arg0;

			SystemProperties sysProp = new SystemProperties(request);

			MDC.put("PCNAME", sysProp.getClientComputerName());
			MDC.put("IPADDRESS", sysProp.getClientIpAddress());
		} catch (Exception e) {
			logger.error("" + e);
		} 
		
		// By calling chain.doFilter / arg2.doFilter, you are handing the request/response to the next filter in your filter chain. 
		// If you do not call it then the next filter (probably defined in your web.xml) will not be executed.

		// If you just called doFilter, then yes you would have endless recursion and a stackoverflow. 
		// However, you are calling the doFilter method of the filterChain object, which instructs it to execute the next filter.
		arg2.doFilter(arg0, arg1);
	}

	/**
	 * Called by the web container to indicate to a filter that it is being taken out of service. 
	 * This method is only called once all threads within the filter's doFilter method have exited or 
	 * after a timeout period has passed. After the web container calls this method, 
	 * it will not call the doFilter method again on this instance of the filter. 
	 *
	 * This method gives the filter an opportunity to clean up any resources that are being held 
	 * (for example, memory, file handles, threads) and make sure that any persistent state is 
	 * synchronized with the filter's current state in memory.
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
