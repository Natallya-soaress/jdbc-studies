package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductDAO {

	private Connection connection;

	public ProductDAO(Connection connection) {
		this.connection = connection;
	}

	public void toSave(Product product) throws SQLException {
		try {
			PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUCT (name, description) VALUES (?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			connection.setAutoCommit(false);

			stm.setString(1, product.getName());
			stm.setString(2, product.getDescription());

			stm.execute();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Rollback performed");
			connection.rollback();
		}
	}

	public List<Product> toList() throws SQLException{
		List<Product> products = new ArrayList<Product>();
		
		try {
			PreparedStatement stm = connection.prepareStatement("SELECT ID, NAME, DESCRIPTION FROM PRODUCT", Statement.RETURN_GENERATED_KEYS);
			connection.setAutoCommit(false);
			
			stm.execute();
			
			try (ResultSet rst = stm.getResultSet();) {
				while (rst.next()) {
					Product product = new Product(rst.getInt(1), rst.getString(2), rst.getString(3));
					products.add(product);
				}
				connection.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Rollback performed");
			connection.rollback();
		}
		return products;
	}
}
