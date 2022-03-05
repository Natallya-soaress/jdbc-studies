import java.sql.SQLException;

import factory.ConnectionFactory;

public class TestingPool {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		for(int i=1; i < 15; i++) {
			connectionFactory.generateConnection();
			System.out.println("Conexão " + i);
		}

	}

}
