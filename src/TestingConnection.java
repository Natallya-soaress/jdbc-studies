import java.sql.Connection;
import java.sql.SQLException;

import factory.ConnectionFactory;

public class TestingConnection {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.generateConnection();
		
		System.out.println("Connection tested!");
		
		connection.close();
	}

}
