package com.batch.fourteen.error;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GlobalExceptionHandler {

	private final static Logger logger = Logger.getLogger(GlobalExceptionHandler.class);
	
	@RequestMapping(value = { "/404.htm" })
	public ModelAndView handle404(HttpServletRequest request, HttpServletResponse response, Exception ex) {
		logger.error("HTTP Status Code: " + response.getStatus());
		return new ModelAndView("error/404");
	}
	
	@RequestMapping(value = { "/500.htm" })
	public ModelAndView handle500(HttpServletRequest request, HttpServletResponse response, Exception ex) {
		logger.error("HTTP Status Code: " + response.getStatus());
		return new ModelAndView("error/500");
	}
	
	@RequestMapping(value = { "/otherError.htm" })
	public ModelAndView otherError(HttpServletRequest request, HttpServletResponse response, Exception ex) {
		logger.error("HTTP Status Code: " + response.getStatus());
		return new ModelAndView("error/maintenance");
	}
}
