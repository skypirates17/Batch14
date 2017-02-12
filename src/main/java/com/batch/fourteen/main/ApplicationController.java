package com.batch.fourteen.main;

import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.batch.fourteen.service.IUserService;
import com.batch.fourteen.utils.JSONParser;
import com.batch.fourteen.utils.Util;
import com.google.gson.Gson;

@Controller
public class ApplicationController {
	
	private final static Logger logger = Logger.getLogger(ApplicationController.class);
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = { "/index" }, method = { RequestMethod.GET })
	public ModelAndView doGet(HttpServletRequest request,
			HttpServletResponse response) throws UnknownHostException {
		
		User user = userService.getUser("172.16.138.72");
		
		logger.debug(user.toString());
		
		return new ModelAndView("index").addObject("USER", user);
	}
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		//

		return new ModelAndView("welcome");
	}

	@RequestMapping("/addUser")
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response) {
		
		//

		return new ModelAndView("welcome");
	}

	@RequestMapping(value = { "/sendMessage" }, method = { RequestMethod.POST })
	@ResponseBody
	public String sendMessage(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String form) {
		
		OutingForm outingForm = JSONParser.getOutingForm(form);
		
		if (Util.isNullOrEmpty(outingForm.getFullName())) {
			return "Please input your name";
		}
		if (Util.isNullOrEmpty(outingForm.getMessage())) {
			return "Please input message";
		}
		if (Util.isNullOrEmpty(outingForm.getAnswerOuting())) {
			return "Please select Are you Going? options";
		}
		if (Util.isNullOrEmpty(outingForm.getAnswerAntipolo())) {
			return "Please select any places in Antipolo";
		}
		
		return new Gson().toJson(outingForm);
	}

}
