package com.ituple.logging.appender.smtp;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestService {
	
	static {
        System.setProperty("log4j.configurationFile", "C:\\Users\\PiyushMittal\\git1\\logging-wrapper-2x2\\src\\main\\java\\com\\ituple\\logging\\appender\\smtp\\log4j2_smtp.xml");
    }
	
	
	private Logger logger = LogManager.getLogger(TestService.class.getName());

	private String[] messages = new String[] { "Hello, World", "Goodbye Cruel World", "You had me at hello" };
	private Random rand = new Random(1);

	public void setMessages(String[] messages) {
		// logger.traceEntry(new JsonMessage(messages));
		this.messages = messages;
		logger.traceExit();
	}

	public void getMessages() {
		// logger.traceEntry();
		// return logger.traceExit(messages, new JsonMessage(messages));
	}

	public String retrieveMessage() {
		logger.entry();
		logger.error("error------------>");
		logger.info("info");
		try{
		throw new Exception();
		}
		catch(Exception e){
			
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			
			logger.error(sw.toString());}
		
		String testMsg = getMessage(getKey());

		return logger.exit(testMsg);
	}

	public void exampleException() {
		logger.entry();
		try {
			String msg = messages[messages.length];
			logger.error("An exception should have been thrown");
		} catch (Exception ex) {
			logger.catching(ex);
			
		}
		logger.exit();
	}

	public String getMessage(int key) {
		logger.entry(key);

		String value = messages[key];

		return logger.exit(value);
	}

	private int getKey() {
		logger.entry();
		int key = rand.nextInt(messages.length);
		return logger.exit(key);
	}
}