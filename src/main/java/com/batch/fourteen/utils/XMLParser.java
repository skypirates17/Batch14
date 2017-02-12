package com.batch.fourteen.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.batch.fourteen.pojo.Message;
import com.batch.fourteen.pojo.User;

public class XMLParser {

	private final static Logger logger = Logger.getLogger(XMLParser.class);

	public static void main(String[] args) {
		for (User user : new XMLParser().parseUsersXML()) {
			logger.debug(user.toString());
		}
	}

	public List<User> parseUsersXML() {
		List<User> lstUsers = new ArrayList<>();

		try {
			InputStream in = XMLParser.class.getResourceAsStream("/Users.xml");

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(in);

			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("batch");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					User user = new User();

					user.setId(eElement.getAttribute("id"));
					user.setIp(eElement.getAttribute("ip"));
					user.setPcName(eElement.getAttribute("pcname"));
					user.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
					user.setNickName(eElement.getElementsByTagName("nickname").item(0).getTextContent());
					user.setEmail(eElement.getElementsByTagName("email").item(0).getTextContent());
					user.setPicFileName(eElement.getElementsByTagName("picfilename").item(0).getTextContent());
					user.setMessages(this.parseMessageXML(eElement.getAttribute("id")));

					lstUsers.add(user);
				}
			}
		} catch (Exception e) {
			logger.debug("Error while parsing xml for Users : " + e);
			e.printStackTrace();
		}
		return lstUsers;
	}

	private List<Message> parseMessageXML(String id) {
		List<Message> messages = new ArrayList<>();

		try {
			InputStream in = XMLParser.class.getResourceAsStream("/Messages.xml");

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(in);

			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("messages");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					String elementId = (String) eElement.getAttribute("id");
					if (elementId != null && id != null && elementId.equalsIgnoreCase(id)) {
						
						
						NodeList nLMessages = eElement.getElementsByTagName("message");
						for (int i = 0; i < nLMessages.getLength(); i++) {
							Message message = new Message();
							Node nMessage = nLMessages.item(i);

							if (nMessage.getNodeType() == Node.ELEMENT_NODE) {
								Element eElement2 = (Element) nMessage;

								message.setId(eElement2.getAttribute("id"));
								message.setMessage(eElement2.getTextContent());
								
								User user = this.getUserInfo(message.getId());
								message.setName(user.getName());
								message.setPicFileName(user.getPicFileName());
							}
							messages.add(message);
						}

						
					}
				}
			}
		} catch (Exception e) {
			logger.debug("Error while parsing xml for Messages : " + e);
			e.printStackTrace();
		}

		return messages;
	}
	
	private User getUserInfo(String id) {
		User user = new User();
		try {
			InputStream in = XMLParser.class.getResourceAsStream("/Users.xml");

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(in);

			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("batch");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					String elementId = (String) eElement.getAttribute("id");
					if (elementId != null && id != null && elementId.equalsIgnoreCase(id)) {
						user.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
						user.setPicFileName(eElement.getElementsByTagName("picfilename").item(0).getTextContent());
						return user;
					}
				}
			}
		} catch (Exception e) {
			logger.debug("Error while parsing xml for Single User : " + e);
			e.printStackTrace();
		}
		return user;
	}
}
