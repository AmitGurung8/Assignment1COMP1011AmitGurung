package org.example.lab5ad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {

    // Defining the database URL, user credentials for connecting to the MySQL database
    private static final String URL = "jdbc:mysql://localhost:3306/Lab5"; // Specifying database URL
    private static final String USER = "Lab5";  // Storing the database username
    private static final String PASSWORD = "Lab5";  // Storing the database password

    // Creating a method to establish a connection to the database
    public static Connection getConnection() throws SQLException {
        // Returning a Connection object using the DriverManager to connect to the database
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
