package com.batch.fourteen.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.batch.fourteen.pojo.User;
import com.batch.fourteen.service.IUserService;
import com.batch.fourteen.utils.XMLParser;

@Service
public class UserService implements IUserService {

	@Override
	public User getUser(String id) {
		List<User> usersList = new XMLParser().parseUsersXML();
		
		for (User user : usersList) {
			if (id.equalsIgnoreCase(user.getIp())) {
				return user;
			}
		}
		
		return null;
	}

}
