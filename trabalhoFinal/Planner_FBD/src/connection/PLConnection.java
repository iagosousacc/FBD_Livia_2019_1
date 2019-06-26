package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PLConnection {
	private final String ip = "localhost";
	private final Integer port = 5432;
	private final String user = "postgres";
	private final String password = "naosei";
	private final String database = "fbd";
	private final String schema = "planner";
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:postgresql://"+ip+":"+port+"/"+database, user, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String getSchema() {
		return this.schema;
	}
}
