import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Removal {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.generateConnection();
		
		PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUCT WHERE ID > 2");
		stm.execute();
		
		Integer rows = stm.getUpdateCount();
		System.out.println("Number of rows modified: " + rows);

	}

}
