package DataBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DbConnectivity {

    private static DbConnectivity instance;


    private final String url = "jdbc:mysql://localhost:3306";
    private final String username ="root";
    private final String password ="iosif";

    private final Connection connection;

    private DbConnectivity() throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public static DbConnectivity getInstance() throws SQLException {
        if (instance == null) {
            instance = new DbConnectivity();
            createTables(instance.getConnection());
        }

        if (instance.getConnection().isClosed()) {
            instance = new DbConnectivity();
        }

        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    private static void createTables(Connection connection) {
        String delimiter = ";";
        try (Scanner scanner = new Scanner(new File("tables.sql"))) {
            scanner.useDelimiter(delimiter);
            while (scanner.hasNext()) {
                String rawStatement = scanner.next() + delimiter;
                if (rawStatement.trim().length() < 2) {
                    continue;
                }
                System.out.println("Executing statement: " + rawStatement);

                try (Statement currentStatement = connection.createStatement()) {
                    currentStatement.execute(rawStatement);
                    System.out.println("Successfully executed statement!");
                } catch (SQLException e) {
                    System.out.println("Failed to execute statement: " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not load file: 'tables.sql'!");
        }
    }

    public void resetTables() {
        String delimiter = ";";
        try (Scanner scanner = new Scanner(new File("reset.sql"))) {
            scanner.useDelimiter(delimiter);
            while (scanner.hasNext()) {
                String rawStatement = scanner.next() + delimiter;
                if (rawStatement.trim().length() < 2) {
                    continue;
                }
                System.out.println("Executing statement: " + rawStatement);

                try (Statement currentStatement = connection.createStatement()) {
                    currentStatement.execute(rawStatement);
                    System.out.println("Successfully executed statement!");
                } catch (SQLException e) {
                    System.out.println("Failed to execute statement: " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not load file: 'tables.sql'!");
        }

        createTables(connection);
    }

}
