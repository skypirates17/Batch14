package com.batch.fourteen.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.batch.fourteen.model.Users;
import com.batch.fourteen.service.UserDatastoreService;

@Service
@Transactional
public class UserDatastore implements UserDatastoreService {

	//@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public void createUserByHibernate(String name, String password) {
		//
	}

	@Override
	public Users loginByUsernameAndPassword(String username, String password) {

		//Criteria criteria = hibernateTemplate.getSessionFactory().openSession().createCriteria(Users.class).add(Restrictions.eq("userName", username)).add(Restrictions.eq("passWord", password));
		//return (Users) criteria.list().get(0);
		return null;
	}

	@Override
	public List getAllUsers(String loggedUserName) {

		//Criteria criteria = hibernateTemplate.getSessionFactory().openSession().createCriteria(Users.class).add(Restrictions.ne("userName", loggedUserName));
		//return criteria.list();
		return null;
	}

	@Override
	public List getOnlineUsers(String loggedUserName) {

		//Criteria criteria = hibernateTemplate.getSessionFactory().openSession().createCriteria(OnlineUser.class).add(Restrictions.eq("liveStatus", 1)).add(Restrictions.ne("userId", loggedUserName));
		//return criteria.list();
		return null;

	}

	@Override
	public void changeMyOnlineStatus(String loggedUserName, int status) {
		/*Criteria criteria = hibernateTemplate.getSessionFactory().openSession().createCriteria(OnlineUser.class).add(Restrictions.eq("userId", loggedUserName));
		if (criteria.list().size() == 0) {
			OnlineUser onlineUsers = new OnlineUser();
			onlineUsers.setLiveStatus(status);
			onlineUsers.setUserId(loggedUserName);
			hibernateTemplate.save(onlineUsers);
		} else {
			OnlineUser onlineUsers = (OnlineUser) criteria.list().get(0);
			onlineUsers.setLiveStatus(status);
			hibernateTemplate.update(onlineUsers);
		}
		*/
	}
}
