package com.shop.app.loggers;

public enum Color {

	RED("\033[0;91m"),

	GREEN("\033[0;92m"),

	BLUE("\033[0;94m"),

	DEFAULT("\033[0m");

	private String value;

	private Color(String value) {

		this.value = value;

	}

	@Override
	public String toString() {
		return value;
	}

}
