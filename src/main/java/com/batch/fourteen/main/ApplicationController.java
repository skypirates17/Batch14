package com.batch.fourteen.main;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.batch.fourteen.pojo.OutingForm;
import com.batch.fourteen.pojo.User;
import com.batch.fourteen.service.IEmailService;
import com.batch.fourteen.service.IUserService;
import com.batch.fourteen.utils.JSONParser;
import com.batch.fourteen.utils.SystemProperties;
import com.batch.fourteen.utils.Util;
import com.google.gson.Gson;

@Controller
public class ApplicationController {

	private final static Logger logger = Logger.getLogger(ApplicationController.class);

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IEmailService emailService;

	@RequestMapping(value = { "/index" }, method = { RequestMethod.GET })
	public ModelAndView doGet(HttpServletRequest request, HttpServletResponse response) throws UnknownHostException {
		
		HttpSession session = request.getSession();
		User user = userService.getUser(new SystemProperties(request).getClientIpAddress());
		session.setAttribute("user", user);
		logger.debug(user.toString());

		return new ModelAndView("index").addObject("USER", user);
	}

	@RequestMapping(value = { "/sendMessage" }, method = { RequestMethod.POST })
	@ResponseBody
	public String sendMessage(HttpServletRequest request, HttpServletResponse response, @RequestParam String form) {
		Map<String, Object> display = new HashMap<>();
		OutingForm outingForm = JSONParser.getOutingForm(form);

		String title = "Required Fields";
		String message = "";
		int errortype = 3;
		if (Util.isNullOrEmpty(outingForm.getFullName())) {
			message = "Please input your name";
		} else if (Util.isNullOrEmpty(outingForm.getMessage())) {
			message = "Please input message";
		} else if (Util.isNullOrEmpty(outingForm.getAnswerOuting())) {
			message = "Please select Are you Going? options";
		} else if (Util.isNullOrEmpty(outingForm.getAnswerAntipolo())) {
			message = "Please select any places in Antipolo";
		} else if (Util.toString(outingForm.getFullName(), true).length() > 100) {
			title = "Field Length!";
			message = "Allowable text length for Name field is upto 100 characters only.";
		} else if (Util.toString(outingForm.getMessage(), true).length() > 250) {
			title = "Field Length!";
			message = "Allowable text length for Message field is upto 250 characters only.";
		} else {
			title = "Message Sent";
			message = "Message successfully sent thru email.";
			errortype = 2;
			
			try {
				HttpSession session = request.getSession();
				emailService.sendEmail((User) session.getAttribute("user"), outingForm);
			} catch (Exception e) {
				title = "Error!";
				message = "Problem encountered while sending emails.";
				errortype = 4;
				
				logger.debug(e.getMessage());
				e.printStackTrace();
				
			}
		}
		
		display.put("TITLE", title);
		display.put("MESSAGE", message);
		display.put("ERRORTYPE", errortype);
		return new Gson().toJson(display);
	}

}
