import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.CategoryDAO;
import dao.ProductDAO;
import factory.ConnectionFactory;
import model.Category;
import model.Product;

public class CategorySelection {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().generateConnection()) {
			CategoryDAO categoryDAO = new CategoryDAO(connection);
			List<Category> categoryList = categoryDAO.toList();
			categoryList.stream().forEach(cl -> {
				System.out.println(cl.getName());
				try {
					for (Product product : new ProductDAO(connection).search(cl)) {
						System.out.println(cl.getName() + " - " + product.getName());
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			});
		}
	}
}
