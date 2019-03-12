package com.shop.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.shop.app.controllers.cli.ShopCliController;
import com.shop.app.loggers.Logger;


public class App {

	public static void main(String[] args) {

		String[] controllers = { "product", "employee" };

		if (0 < args.length) {

			List<String> options = new ArrayList<String>(Arrays.asList(args));
			Logger logger = new Logger();

			try {
				if (options.get(0).contentEquals(controllers[0])) {
					options.remove(0);
					new ShopCliController(options, logger);
					return;
				}
			} catch (RuntimeException e) {
				logger.emergency(e.getMessage());
				return;
			}
			System.out.println("Following options accepted: " + options);
		}

	}
}
