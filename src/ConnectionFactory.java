import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection generateConnection() throws SQLException {

		return DriverManager.getConnection("jdbc:mysql://localhost/store?useTimezone=true&serverTimezone=UTC", "root", "B!cicleta04");
	
	}
}
