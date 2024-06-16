package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.DriverManager;

public class DB {
    private static Connection connection = null;

    private static Properties dbProperties() {
        try (FileInputStream file = new FileInputStream("db.properties")) {
            Properties properties = new Properties();
            properties.load(file);
            return properties;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Properties properties = dbProperties();
                connection = DriverManager.getConnection(
                        properties.getProperty("dburl"),
                        properties.getProperty("user"),
                        properties.getProperty("password")
                );
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
