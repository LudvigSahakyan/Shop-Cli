package com.shop.app.loggers;

public interface ILogger {

	
	public void success(String message);
	
	public void error(String message);
	
	public void info(String message);
	
	public void emergency(String message);
	
	public void log(String message);
	
	public void log(String message, Boolean concat);
	
	
	
	
	
	
	
	
	
	
}


