import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Product;

public class Insertion {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Product phone = new Product("Phone", "Xioami Phone");

		

		try (Connection connection = connectionFactory.generateConnection()) {
			try {
				PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUCT (name, description) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
				connection.setAutoCommit(false); 
				
				makeInsert("Tv", "Smart tv", stm);
				makeInsert(phone.getName(), phone.getDescription(), stm);

				connection.commit();

				stm.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Rollback performed");
				connection.rollback();
			}
		}

	}

	private static void makeInsert(String name, String description, PreparedStatement stm) throws SQLException {
		stm.setString(1, name);
		stm.setString(2, description);

		stm.execute();

		ResultSet rst = stm.getGeneratedKeys();

		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("The id created was: " + id);
		}
	}

}
