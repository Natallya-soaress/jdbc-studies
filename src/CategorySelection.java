import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.CategoryDAO;
import factory.ConnectionFactory;
import model.Category;
import model.Product;

public class CategorySelection {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().generateConnection()) {
			CategoryDAO categoryDAO = new CategoryDAO(connection);
			List<Category> categoryList = categoryDAO.toListComplete();
			categoryList.stream().forEach(cl -> {
				System.out.println(cl.getName());
				for (Product product : cl.getProducts()) {
					System.out.println(cl.getName() + " - " + product.getName());
				}
			});
		}
	}
}
