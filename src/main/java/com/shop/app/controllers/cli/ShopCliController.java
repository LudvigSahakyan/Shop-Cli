package com.shop.app.controllers.cli;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import com.shop.app.loggers.Logger;
import com.shop.app.models.Product;
import com.shop.app.repositories.productrepositories.ProductRepository;

public class ShopCliController extends CliController implements ICrud {

	public ShopCliController(List<String> options, Logger logger) {

		super(options, logger);

		if (0 < options.size()) {

			if (options.get(0).contentEquals("create")) {

				create();
				return;
			} else if (options.get(0).contentEquals("update")) {

				update();
				return;
			} else if (options.get(0).contentEquals("read")) {

				read();
				return;
			} else if (options.get(0).contentEquals("delete")) {

				delete();
				return;
			}
		}
		logger.log("Usage: product <command>\n");
		logger.log("where <command> is on of:");
		logger.log("\tcreate, read, update, delete.");
	}

	@Override
	public void create() {
		Product product = new Product();
		ProductRepository repository = new ProductRepository();

		try {
			logger.info("Answer the following questions!");
			logger.log("Enter a product name: ");
			product.setName(scanner.next());
			logger.log("Enter a product price: ");
			product.setPrice(scanner.nextFloat());
			logger.log("Enter a product quality: ");
			product.setQuantity(scanner.nextInt());
			repository.persist(product);

			logger.success(product.getQuantity() + " " + product.getName() + " of " + product.getPrice()
					+ " euro each has been added");

		} catch (InputMismatchException e) {
			logger.error("\n Value \"" + scanner.nextLine() + "\" is not acceptable");
		} catch (SQLException e) {
			logger.error(e.getMessage());
		} finally {
			scanner.close();
		}
	}

	@Override
	public void read() {

		ProductRepository repository = new ProductRepository();

		logger.info("Please find below your product list!\n");

		try {
			List<Product> products = repository.findAll();

			if (options.contains("--asc")) {
				products.sort((Product o1, Product o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
			} else if (options.contains("--desc")) {
				products.sort((Product o1, Product o2) -> o2.getName().compareToIgnoreCase(o1.getName()));
			}

			Iterator<Product> iterator = products.iterator();

			while (iterator.hasNext()) {

				Product product = (Product) iterator.next();
				logger.info(" " + product.getName() + ": " + product.getPrice() + " euro " + product.getQuantity()
						+ " items");
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}

	}

	@Override
	public void update() {

		Product product = new Product();
		ProductRepository repository = new ProductRepository();

		try {

			logger.info("Please choose the product you want to update!");
			logger.log("Enter a product name: ");
			product.setName(scanner.next());

			logger.log("Enter a product price: n to ignore");

			product.setPrice(scanner.nextFloat());

			logger.log("Enter a product quality: n to ignore");

			product.setQuantity(scanner.nextInt());

			repository.update(product);

			logger.success(" " + product.getName() + " has successfuly been updated");
			logger.success(" there are currently " + product.getQuantity() + " " + product.getName() + " of "
					+ product.getPrice() + " euros each");

		} catch (InputMismatchException e) {
			logger.error("\n Value \"" + scanner.nextLine() + "\" is not acceptable");
		} catch (SQLException e) {

			logger.error(e.getMessage());
		} finally {
			scanner.close();
		}
	}

	@Override
	public void delete() {

		System.out.println("delete");

	}

}
