package com.shop.app.managers;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


import com.shop.app.resources.Resource;

public class Manager {

	private static Connection connection;

	private Manager() {
	
		Resource resource = new Resource("mysql");
		
		Properties properties = new Properties();
		properties.put("user", resource.getXmlElement("user"));
		properties.put("password", resource.getXmlElement("password"));
		connection = DriverManager.getConnection(resource.getXmlElement("url"), properties);
	}

	public static Connection getConnection() {

		try {
			if (null == connection) {
				new Manager();
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return connection;
	}
}
