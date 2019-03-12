package com.shop.app.loggers;

public class Logger implements ILogger {

	public Logger() {

	}

	@Override
	public void success(String message) {

		log("[" + Color.GREEN + Level.SUCCESS + Color.DEFAULT + "] " + message, false);

	}

	@Override
	public void error(String message) {

		log("[" + Color.RED + Level.ERROR + Color.DEFAULT + "]" + message, false);

	}

	@Override
	public void info(String message) {

		log("[" + Color.BLUE + Level.INFO + Color.DEFAULT + "]" + message, false);

	}

	@Override
	public void emergency(String message) {

		log(Color.RED + "[" + Level.EMERGENCY + "] " + message, false);

	}

	@Override
	public void log(String message) {

		System.out.print(message);

	}

	@Override
	public void log(String message, Boolean concat) {

		System.out.println(message);

	}

}
