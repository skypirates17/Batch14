package com.batch.fourteen.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import com.batch.fourteen.pojo.OutingForm;
import com.batch.fourteen.pojo.User;

public interface IEmailService {

	void sendEmail(User user, OutingForm outingForm) throws MessagingException, UnsupportedEncodingException ;
}
