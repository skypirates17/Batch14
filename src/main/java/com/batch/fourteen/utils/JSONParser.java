package com.batch.fourteen.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.batch.fourteen.pojo.OutingForm;

public class JSONParser {

	private static String sample = "[{\"name\":\"answer_antipolo\",\"value\":\"Antipolo Cathedral\"},{\"name\":\"answer_antipolo\",\"value\":\"Boso Boso Church\"},{\"name\":\"answer_antipolo\",\"value\":\"Bosay Resort\"},{\"name\":\"answer_antipolo\",\"value\":\"Mystical Cave\"},{\"name\":\"answer_antipolo\",\"value\":\"Cloud 9, 360 View\"},{\"name\":\"answer_outing\",\"value\":\"Yes\"},{\"name\":\"fullname\",\"value\":\"sdfsdfsdf\"},{\"name\":\"message\",\"value\":\"sdfsdfsdfsdfsdfsdf\"}]";
	
	// fields
	private static final String NAME = "name";
	private static final String VALUE = "value";
	private static final String ANSWER = "answer_antipolo";
	private static final String OUTING = "answer_outing";
	private static final String FULLNAME = "fullname";
	private static final String MESSAGE = "message";
	
	public static OutingForm getOutingForm(String strJson) {
		OutingForm outingForm = new OutingForm();
		List<String> answer = new ArrayList<String>();
		
		JSONArray jsonArr = new JSONArray(strJson);
		Iterator<Object> iterator = jsonArr.iterator();
		while (iterator.hasNext()) {
			JSONObject jsonObject = (JSONObject) iterator.next();
			String fieldName = (String) jsonObject.get(NAME);
			String value = (String) jsonObject.get(VALUE);
			
			if (fieldName.equalsIgnoreCase(ANSWER)) {
				answer.add(value);
			} else if (fieldName.equalsIgnoreCase(OUTING)) {
				outingForm.setAnswerOuting(value);
			} else if (fieldName.equalsIgnoreCase(FULLNAME)) {
				outingForm.setFullName(value);
			} else if (fieldName.equalsIgnoreCase(MESSAGE)) {
				outingForm.setMessage(value);
			}
		}
		
		outingForm.setAnswerAntipolo(answer);
		return outingForm;
	}
	
	public static void main(String[] args) {
		OutingForm of = new JSONParser().getOutingForm(sample);
		
		System.out.println(of.toString());
		
	}
}
