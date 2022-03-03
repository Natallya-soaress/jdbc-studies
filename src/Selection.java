import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Selection {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.generateConnection();
		
		PreparedStatement stm = connection.prepareStatement("SELECT ID, NAME, DESCRIPTION  FROM PRODUCT");
		stm.execute();
		
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			Integer id = rst.getInt("ID");
			System.out.println(id);
			String name = rst.getString("NAME");
			System.out.println(name);
			String description = rst.getString("DESCRIPTION");
			System.out.println(description);
		}
		
		
		connection.close();

	}

}
