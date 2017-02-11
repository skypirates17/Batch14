package com.batch.fourteen.pojo;

import java.util.List;

public class OutingForm {

	private String fullName;

	private String message;

	private String answerOuting;

	private List<String> answerAntipolo;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAnswerOuting() {
		return answerOuting;
	}

	public void setAnswerOuting(String answerOuting) {
		this.answerOuting = answerOuting;
	}

	public List<String> getAnswerAntipolo() {
		return answerAntipolo;
	}

	public void setAnswerAntipolo(List<String> answerAntipolo) {
		this.answerAntipolo = answerAntipolo;
	}

	@Override
	public String toString() {
		return this.fullName + ", " + message + ", " + answerOuting + ", " + answerAntipolo.toString();
	}
}
