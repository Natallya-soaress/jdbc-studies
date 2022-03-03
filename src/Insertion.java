import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Insertion {

	public static void main(String[] args) throws SQLException {
		 

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.generateConnection();
		connection.setAutoCommit(false);
		
		try {
			PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUCT (name, description) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			makeInsert("Tv", "Smart tv", stm);
			
			connection.commit();
			
			stm.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Rollback performed");
			connection.rollback();
		} 
		}
		

	private static void makeInsert(String name, String description, PreparedStatement stm) throws SQLException {
		stm.setString(1, name);
		stm.setString(2, description);
		
		stm.execute();
		
		ResultSet rst = stm.getGeneratedKeys();
		
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("The id created was: " + id);
		}
	}

}
