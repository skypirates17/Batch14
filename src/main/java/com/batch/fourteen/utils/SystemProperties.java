package com.batch.fourteen.utils;

import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SystemProperties is a user-defined class used to retrieve server and client IP Address and Host Name
 * 
 * @author jangolluan
 * @since June 03, 2016
 */
public class SystemProperties {
	
	private String clientIpAddress;
	private String clientComputerName;
	
	private String serverIpAddress;
	private String serverComputerName;
	
	private HttpServletRequest request;
	
	private final Logger logger = LoggerFactory.getLogger(SystemProperties.class);
	
	public SystemProperties(HttpServletRequest request) {
		this.request = request;
		setClientInfo();
		setServerInfo();
	}
	
	public String getClientIpAddress() {
		return this.clientIpAddress;
	}
	
	public String getClientComputerName() {
		return this.clientComputerName;
	}
	
	public String getServerIpAddress() {
		return this.serverIpAddress;
	}
	
	public String getServerComputerName() {
		return this.serverComputerName;
	}
	
	private void setClientInfo() {
		try {
			this.clientIpAddress = request.getRemoteAddr(); 
	        InetAddress inetAddress = InetAddress.getByName(request.getRemoteAddr());
	        this.clientComputerName =  inetAddress.getHostName();
		} catch (Exception e) {
			logger.error("Unable to get Client System Properties {} " + e);
			e.printStackTrace();
		}
	}
	
	private void setServerInfo() {
		try {
			this.serverIpAddress = InetAddress.getLocalHost().getHostAddress(); 
	        this.serverComputerName =  InetAddress.getLocalHost().getHostName();
		} catch (Exception e) {
			logger.error("Unable to get Server System Properties {} " + e);
			e.printStackTrace();
		}
	}
}
