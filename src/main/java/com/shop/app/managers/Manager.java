package com.shop.app.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Manager {

	private static Connection connection;

	private Manager() throws SQLException {

		Properties properties = new Properties();
		properties.put("user", "root");
		properties.put("password", "");
		String url = "jdbc:mysql://localhost:3306/formation_java";
		connection = DriverManager.getConnection(url, properties);
	}

	public static Connection getConnection() throws RuntimeException {

		try {
			if (null == connection) {
				new Manager();
			}
		} catch (SQLException e) {
			throw new RuntimeException("Database connection error");
		}
		return connection;
	}
}
