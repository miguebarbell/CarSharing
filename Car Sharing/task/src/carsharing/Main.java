package carsharing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        String JDBC_DRIVER = "org.h2.Driver";
        String jdbcURL = "jdbc:h2:file:./src/carsharing/db/anything";
            if (args.length >=2 && args[0].equals("-databaseFileName")) {
                jdbcURL = "jdbc:h2:file:./src/carsharing/db/" + args[1];
        }
            Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(jdbcURL);
            System.out.println("Connected to H2 in-memory database.");
            String sql = "Create table COMPANY (ID int primary key, NAME varchar(50))";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            connection.setAutoCommit(true);
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
