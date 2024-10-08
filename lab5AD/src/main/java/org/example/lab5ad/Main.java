package org.example.lab5ad;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// NAME - AMIT GURUNG
// LAB 5
// Used my own try catch and connection method from Youtubee


public class Main extends DBUtility {

    public static void main(String[] args) {

        // Declaring necessary objects for establishing database connection and executing queries
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Getting the connection from DBUtility class (for connecting to the database)
            connection = getConnection();

            // Creating a Statement object for executing SQL queries
            statement = connection.createStatement();

            // Defining the SQL query to retrieve all data from the 'Exercises' table
            String query = "SELECT * FROM Exercises";

            // Executing the query and retrieving the result set containing the table data
            resultSet = statement.executeQuery(query);

            // Creating a formatted header string for displaying the output table with columns
            String header = String.format("| %-5s | %-20s | %-12s | %-15s | %-10s | %-5s |",
                    "ID", "Exercise Name", "Difficulty", "Calories Burned", "Reps", "Sets");

            // Generating the double and single line strings to enhance the table appearance
            // The lengths of the lines are determined by the header size for proper alignment
            String doubleLine = "=".repeat(header.length()); // For the top and bottom borders
            String singleLine = "-".repeat(header.length()); // For separating each row

            // Printing the top border, header, and bottom border of the header section
            System.out.println(doubleLine); // Printing the top border of the table
            System.out.println(header);     // Printing the column headers
            System.out.println(doubleLine); // Printing the border under the headers

            // Looping through each row in the result set (each exercise)
            while (resultSet.next()) {
                // Retrieving values from each column of the current row
                int eID = resultSet.getInt("eID");               // Getting Exercise ID
                String eName = resultSet.getString("eName");     // Getting Exercise Name
                String eDifficulty = resultSet.getString("eDifficulty"); // Getting Difficulty Level
                int caloriesBurned = resultSet.getInt("caloriesBurned"); // Getting Calories Burned
                String reps = resultSet.getString("reps");       // Getting Reps
                String sets = resultSet.getString("sets");       // Getting Sets

                // Printing each row in a formatted manner with vertical separators (|) between columns
                System.out.printf("| %-5d | %-20s | %-12s | %-15d | %-10s | %-5s |%n",
                        eID, eName, eDifficulty, caloriesBurned, reps, sets);

                // Printing a single line to separate each row for better readability
                System.out.println(singleLine);
            }

        } catch (SQLException e) {
            // Catching and printing any SQL exceptions that occur during the process
            System.err.println("SQL Exception: " + e.getMessage());
        } finally {
            // Closing the result set, statement, and connection objects to free up resources
            try {
                if (resultSet != null) resultSet.close();       // Closing the result set
                if (statement != null) statement.close();       // Closing the statement
                if (connection != null) connection.close();     // Closing the connection
            } catch (SQLException e) {
                // Handling any exceptions that occur during the closing of resources
                System.err.println("SQL Exception on close: " + e.getMessage());
            }
        }
    }
}
