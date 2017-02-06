package com.batch.fourteen.main;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.batch.fourteen.model.Users;
import com.batch.fourteen.service.UserDatastoreService;

@Controller
public class ApplicationController {

	@Autowired
	UserDatastoreService userDatastoreService;

	@RequestMapping(value = { "/index.htm" }, method = { RequestMethod.GET })
	public ModelAndView doGet(HttpServletRequest request,
			HttpServletResponse response) throws UnknownHostException {

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

	@RequestMapping("/sendMessage")
	public ModelAndView sendMessage(HttpServletRequest request, HttpServletResponse response) {
		//
		return new ModelAndView("welcome");
	}

	@RequestMapping("/getMyMessages")
	public void getMyMessages(HttpServletRequest request, HttpServletResponse response) {

		//
	}

	@RequestMapping("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) {

		//
	}

	@RequestMapping("/getAllUsers")
	public void getAllUsers(HttpServletRequest request, HttpServletResponse response) {
		//
	}

	@RequestMapping("/getPrev")
	public void getPrev(HttpServletRequest request, HttpServletResponse response) {
		//
	}

	@RequestMapping("/getNext")
	public void getNext(HttpServletRequest request, HttpServletResponse response) {
		//
	}

	@RequestMapping("/getOnlineUsers")
	public void getOnlineUsers(HttpServletRequest request, HttpServletResponse response) {
		//
	}
}
