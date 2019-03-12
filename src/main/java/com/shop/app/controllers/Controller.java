package com.shop.app.controllers;

import com.shop.app.loggers.ILogger;


public class Controller {

	protected ILogger logger;

	public Controller(ILogger logger) {
		setILogger(logger);

	}

	public void setILogger(ILogger logger) {

		this.logger = logger;

	}

	public ILogger getILogger() {

		return logger;

	}

}
