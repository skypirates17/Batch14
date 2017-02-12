package com.batch.fourteen.test;

import org.apache.log4j.Logger;

public class TestFile {

	private final static Logger logger = Logger.getLogger(TestFile.class);
	
	public static void main(String[] args) {
		logger.debug("LOGGER");
		System.out.println("SYSOUT");
	}

}
