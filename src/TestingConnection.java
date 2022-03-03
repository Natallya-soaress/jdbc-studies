import java.sql.Connection;
import java.sql.SQLException;

public class TestingConnection {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.generateConnection();
		
		System.out.println("Connection tested!");
		
		connection.close();
	}

}
