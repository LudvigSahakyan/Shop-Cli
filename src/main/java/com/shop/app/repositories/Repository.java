package com.shop.app.repositories;

import java.sql.Connection;

import com.shop.app.managers.Manager;

public class Repository {
	
	
	public Repository() {
		
	}
	
	public Connection getConnection() {
		
		return Manager.getConnection();	
		
	}
	

}
