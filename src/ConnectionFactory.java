import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	public DataSource dataSource;
	
	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSouce = new ComboPooledDataSource();
		comboPooledDataSouce.setJdbcUrl("jdbc:mysql://localhost/store?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSouce.setUser("root");
		comboPooledDataSouce.setPassword("B!cicleta04");
		comboPooledDataSouce.setMaxPoolSize(10);
		
		
		this.dataSource = comboPooledDataSouce;
	}
	
	public Connection generateConnection() throws SQLException {

		return this.dataSource.getConnection();
	
	}
}
