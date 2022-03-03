import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Insertion {

	public static void main(String[] args) throws SQLException {
		
		String name = "Mouse";
		String description = "Wireless mouse"; 

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.generateConnection();
		
		PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUCT (name, description) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
		
		
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
