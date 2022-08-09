package carsharing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {
	public CompanyDAOImpl companydao = new CompanyDAOImpl();
	private String sql =
			"Create table IF NOT EXISTS COMPANY (ID int PRIMARY KEY AUTO_INCREMENT, NAME varchar(50) UNIQUE NOT NULL)";
	private String JDBC_DRIVER = "org.h2.Driver";
	private String JDBC_URL = "jdbc:h2:file:./src/carsharing/db/anything";

	private Connection connection = null;
	private Statement statement = null;
	public DatabaseConnector(String[] args) {
		if (args.length >=2 && args[0].equals("-databaseFileName")) {
			this.JDBC_URL = "jdbc:h2:file:./src/carsharing/db/" + args[1];
		}
		connect();
//		try {
//			Class.forName(JDBC_DRIVER);
//			connection = DriverManager.getConnection(JDBC_URL);
//			System.out.println("Connected to H2 in-memory database.");
//			Statement statement = connection.createStatement();
//			statement.executeUpdate(sql);
//			connection.setAutoCommit(true);
//			statement.close();
//			connection.close();
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException(e);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
	void connect() {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(JDBC_URL);
//			System.out.println("Connected to H2 in-memory database.");
			statement = connection.createStatement();
			connection.setAutoCommit(true);
			executeQuery(this.sql);

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	void disconnect() throws SQLException {
//		System.out.println("Disconnecting...");
		statement.close();
		connection.close();
//		System.out.println("Disconnected from database.");
	}
	void executeQuery(String sql) throws SQLException {
		statement.executeUpdate(sql);
	}



}
