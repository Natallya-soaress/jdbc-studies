import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.ProductDAO;
import model.Product;

public class DAOInsertion {

	public static void main(String[] args) throws SQLException {

		Product stove = new Product("Stove", "Eletric stove");
		Product table = new Product("Table", "Wooden table");
		
		try(Connection connection = new ConnectionFactory().generateConnection()){
			ProductDAO productDAO = new ProductDAO(connection);
			productDAO.toSave(stove);
			productDAO.toSave(table);
			List<Product> productsList = productDAO.toList();
			productsList.stream().forEach(pl -> System.out.println(pl));
			
		}
	}
}
