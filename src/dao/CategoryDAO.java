package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Category;
import model.Product;

public class CategoryDAO {

	private Connection connection;

	public CategoryDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Category> toList() throws SQLException {

		List<Category> categoryList = new ArrayList<Category>();

		try (PreparedStatement stm = connection.prepareStatement("SELECT * FROM Category")) {
			stm.execute();

			try (ResultSet rst = stm.getResultSet()) {
				while (rst.next()) {
					Category category = new Category(rst.getInt(1), rst.getString(2));
					categoryList.add(category);
				}
			}
		}

		return categoryList;
	}

	public List<Category> toListComplete() throws SQLException {

		Category last = null;
		List<Category> categoryList = new ArrayList<Category>();

		try (PreparedStatement stm = connection.prepareStatement(
				"SELECT C.ID, C.NAME, P.ID, P.NAME, P.DESCRIPTION FROM CATEGORY C INNER JOIN PRODUCT P ON C.ID = P.CATEGORY_ID")) {
			stm.execute();

			try (ResultSet rst = stm.getResultSet()) {
				while (rst.next()) {
					if(last == null || !last.getName().equals(rst.getString(2))) {
						Category category = new Category(rst.getInt(1), rst.getString(2));
						last = category;
						categoryList.add(category);
					}
					Product product = new Product(rst.getInt(3), rst.getString(4), rst.getString(4));
					last.add(product);
					
				}
			}
		}
		return categoryList;
	}
}
