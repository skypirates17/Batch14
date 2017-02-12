package com.batch.fourteen.pojo;

import java.util.List;

public class User {

	private String id;
	private String ip;
	private String pcName;
	private String name;
	private String nickName;
	private String email;
	private String picFileName;
	private List<Message> messages;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPcName() {
		return pcName;
	}

	public void setPcName(String pcName) {
		this.pcName = pcName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPicFileName() {
		return picFileName;
	}

	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("{id=" + this.id);
		sb.append(", name=" + this.name);
		sb.append(", ip=" + this.ip);
		sb.append(", pcName=" + this.pcName);
		sb.append(", email=" + this.email);
		sb.append(", picFileName=" + this.picFileName);
		sb.append(", nickName=" + this.nickName);
		sb.append(", messages=" + this.messages.toString() + "}");

		return sb.toString();
	}
}
