package com.shop.app.controllers.cli;


import java.util.List;
import java.util.Scanner;
import com.shop.app.controllers.Controller;
import com.shop.app.loggers.Logger;

public class CliController extends Controller {
	
	
	protected Scanner scanner = new Scanner(System.in);
	protected List<String> options;
	
	
	public CliController (List<String> options, Logger logger)  {
		
		super(logger);
		this.options = options;

	
	}

	
	
	
	
}
