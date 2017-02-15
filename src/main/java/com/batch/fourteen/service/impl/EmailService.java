package com.batch.fourteen.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.batch.fourteen.pojo.OutingForm;
import com.batch.fourteen.pojo.User;
import com.batch.fourteen.service.IEmailService;
import com.batch.fourteen.utils.XMLParser;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

@Service
public class EmailService implements IEmailService {

	private final static Logger logger = Logger.getLogger(EmailService.class);
	private final String HOST = "mailsrv01.domain.aeoncredit.com.ph";
	private final String SMTP = "192.168.100.125";
	private final String SUBJECT = "Batch 2nd Anniversary";

	@Override
	public void sendEmail(User user, OutingForm outingForm) throws MessagingException, UnsupportedEncodingException {
		logger.debug(user.toString());
		logger.debug(outingForm.toString());

		List<User> usersList = new XMLParser().parseUsersXML();
		logger.debug(usersList.toString());

		// send email
		Properties properties = System.getProperties();

		properties.put("mail.smtp.localhost", HOST);
		properties.put("mail.smtp.host", SMTP);
		properties.put("mail.debug", true);
		properties.put("mail.debug.auth", true);

		Session session = Session.getInstance(properties, null);
		session.setDebug(true);

		MimeMessage message = new MimeMessage(session);
		message.setSubject(SUBJECT, "utf-8");
		message.setFrom(new InternetAddress(user.getEmail(), user.getName()));
		message.setSentDate(new Date());

		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(this.setTable(outingForm), "text/html; charset=utf-8");
		logger.debug(this.setTable(outingForm));
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		message.setContent(multipart);
		
		for (int i = 0; i < usersList.size(); i++) {
			User toRecipient = usersList.get(i);
			if (toRecipient.getEmail().equalsIgnoreCase(user.getEmail())) continue;
			
			message.addRecipient(RecipientType.TO, new InternetAddress(toRecipient.getEmail()));
			
			logger.debug("Sending Email from " + user.getEmail() +" to "+toRecipient.getEmail());
			//Transport.send(message);
			
		}
		
	}
	
	private String setTable(OutingForm outingForm) {
		StringBuilder sb = new StringBuilder();

		sb.append("<table style='border-collapse: collapse; border: 1px solid black;'>");

		sb.append("<tbody>");
		sb.append("<tr>");
		sb.append("<td style=' border: 1px solid black;'><b>Name nya dw<b></td>");
		sb.append("<td style=' border: 1px solid black;'>"+outingForm.getFullName()+"</td>");
		sb.append("</tr>");
		
		sb.append("<tr>");
		sb.append("<td style=' border: 1px solid black;'><b>Place(s) I want to visit in Antipolo<b></td>");
		String antipolo = "";
		for (int i = 0; i < outingForm.getAnswerAntipolo().size(); i++) {
			antipolo += outingForm.getAnswerAntipolo().get(i) + "<br>";
		}
		sb.append("<td style=' border: 1px solid black;'>"+antipolo+"</td>");
		sb.append("</tr>");
		
		sb.append("<tr>");
		sb.append("<td style=' border: 1px solid black;'><b>Pupunta ba ko?<b></td>");
		sb.append("<td style=' border: 1px solid black;'>"+outingForm.getAnswerOuting()+"</td>");
		sb.append("</tr>");
		
		sb.append("<tr>");
		sb.append("<td style=' border: 1px solid black;'><b>Message<b></td>");
		sb.append("<td style=' border: 1px solid black;'>"+outingForm.getMessage()+"</td>");
		sb.append("</tr>");
		
		sb.append("</tbody>");
		sb.append("</table>");

		return sb.toString();
	}


}
