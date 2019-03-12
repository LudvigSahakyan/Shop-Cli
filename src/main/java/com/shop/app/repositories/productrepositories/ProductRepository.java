package com.shop.app.repositories.productrepositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shop.app.models.Product;
import com.shop.app.repositories.Repository;

public class ProductRepository extends Repository {

	public ProductRepository() {

	}

	public void persist(Product product) throws SQLException {

		Connection connection = getConnection();
		String sql = "INSERT INTO `product` (`name`,`price`,`quantity`) VALUES (?, ?, ?)";
		PreparedStatement state = connection.prepareStatement(sql);
		state.setString(1, product.getName());
		state.setFloat(2, product.getPrice());
		state.setInt(3, product.getQuantity());
		state.executeUpdate();
	}

	public void update(Product product) throws SQLException {

		Connection connection = getConnection();
		String sql = "UPDATE `product` SET `price`=?,`quantity`=? WHERE `name`=?";
		PreparedStatement state = connection.prepareStatement(sql);
		state.setString(3, product.getName());
		state.setFloat(1, product.getPrice());
		state.setInt(2, product.getQuantity());
		state.executeUpdate();

	}

	public List<Product> findAll () throws SQLException {
		
		List<Product> products = new ArrayList<Product>();

		Connection connection = getConnection();
		String sql = "SELECT `name`,`price`,`quantity` FROM `product`";
		Statement state = connection.createStatement();
		ResultSet results = state.executeQuery(sql);
		while (results.next()) {	
			Product product = new Product();
			product.setName(results.getString("name"));
			product.setPrice(results.getFloat("price"));
		    product.setQuantity(results.getInt("quantity"));
		    products.add(product);	
		}
		return products;
		
	}

}
