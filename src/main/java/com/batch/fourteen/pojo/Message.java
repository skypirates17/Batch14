package com.batch.fourteen.pojo;

public class Message {

	private String id;
	private String message;
	private String name;
	private String picFileName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicFileName() {
		return picFileName;
	}

	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("{id=" + this.id);
		sb.append(", name=" + this.name);
		sb.append(", picFileName=" + this.picFileName);
		sb.append(", message=" + this.message + "}");

		return sb.toString();
	}

}
