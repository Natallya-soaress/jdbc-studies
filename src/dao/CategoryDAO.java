package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Category;

public class CategoryDAO {
	
	private Connection connection;

	public CategoryDAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<Category> toList() throws SQLException{
		
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
}
