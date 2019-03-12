package com.shop.app.managers;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


import com.shop.app.resources.Resource;

public class Manager {

	private static Connection connection;

	private Manager() throws SQLException, RuntimeException {
	
		Resource resource = new Resource("mysql");
		
		Properties properties = new Properties();
		properties.put("user", resource.getXmlElement("user"));
		properties.put("password", resource.getXmlElement("password"));
		connection = DriverManager.getConnection(resource.getXmlElement("url"), properties);
	}

	public static Connection getConnection() throws RuntimeException {

		try {
			if (null == connection) {
				new Manager();
			}
		} catch (SQLException | RuntimeException e) {
			e.printStackTrace();
			throw new RuntimeException("Database connection error");
		}
		return connection;
	}
}
