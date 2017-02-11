package com.batch.fourteen.main;

import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.batch.fourteen.pojo.OutingForm;
import com.batch.fourteen.service.UserDatastoreService;
import com.batch.fourteen.utils.JSONParser;
import com.batch.fourteen.utils.Util;
import com.google.gson.Gson;

@Controller
public class ApplicationController {

	@Autowired
	UserDatastoreService userDatastoreService;

	private final static Logger logger = LoggerFactory.getLogger(ApplicationController.class);
	
	@RequestMapping(value = { "/index" }, method = { RequestMethod.GET })
	public ModelAndView doGet(HttpServletRequest request,
			HttpServletResponse response) throws UnknownHostException {
		logger.debug("" + request.getParameter("MESSAGE"));
		logger.debug("" + request.getParameter("firstName"));
		logger.debug("JOHNREY");
		return new ModelAndView("index");
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
