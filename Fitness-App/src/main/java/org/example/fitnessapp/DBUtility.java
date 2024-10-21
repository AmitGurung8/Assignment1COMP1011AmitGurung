package org.example.fitnessapp;

import javafx.scene.chart.XYChart; // Importing necessary class for chart representation
import java.sql.Connection; // Importing classes for SQL connection
import java.sql.DriverManager; // Importing class to manage the database driver
import java.sql.ResultSet; // Importing class to manage result set of SQL queries
import java.sql.SQLException; // Importing class for handling SQL exceptions
import java.sql.Statement; // Importing class to execute SQL statements
import java.util.ArrayList; // Importing class for dynamic array list
import java.util.List; // Importing class for list interface

public class DBUtility {
    private static String user = "root"; // Setting database user
    private static String password = "amit"; // Setting database password
    private static String connectURL = "jdbc:mysql://localhost:3306/fitness"; // Setting connection URL
    private static Connection connection; // Declaring connection object

    // Method to connect to the database
    public static void connect() {
        try {
            // Establishing connection to the database
            connection = DriverManager.getConnection(connectURL, user, password);
        } catch (SQLException e) {
            // Printing stack trace in case of connection failure
            e.printStackTrace();
        }
    }

    // Method to retrieve push exercise calories burned
    public static XYChart.Series<String, Integer> getPushCaloriesBurned() {
        XYChart.Series<String, Integer> pushCaloriesSeries = new XYChart.Series<>(); // Creating series for chart
        String sql = "SELECT eName, SUM(caloriesBurned) AS totalCalories FROM Push GROUP BY eName ORDER BY totalCalories DESC;"; // SQL query

        try (
                Statement statement = connection.createStatement(); // Creating statement object
                ResultSet resultSet = statement.executeQuery(sql) // Executing query
        ) {
            // Iterating through result set
            while (resultSet.next()) {
                String eName = resultSet.getString("eName"); // Retrieving exercise name
                int totalCalories = resultSet.getInt("totalCalories"); // Retrieving total calories burned
                // Adding data to series
                pushCaloriesSeries.getData().add(new XYChart.Data<>(eName, totalCalories));
            }
        } catch (SQLException e) {
            // Printing stack trace in case of SQL exception
            e.printStackTrace();
        }
        return pushCaloriesSeries; // Returning series
    }

    // Method to retrieve pull exercise calories burned
    public static XYChart.Series<String, Integer> getPullCaloriesBurned() {
        XYChart.Series<String, Integer> pullCaloriesSeries = new XYChart.Series<>(); // Creating series for chart
        String sql = "SELECT eName, SUM(caloriesBurned) AS totalCalories FROM Pull GROUP BY eName ORDER BY totalCalories DESC;"; // SQL query

        try (
                Statement statement = connection.createStatement(); // Creating statement object
                ResultSet resultSet = statement.executeQuery(sql) // Executing query
        ) {
            // Iterating through result set
            while (resultSet.next()) {
                String eName = resultSet.getString("eName"); // Retrieving exercise name
                int totalCalories = resultSet.getInt("totalCalories"); // Retrieving total calories burned
                // Adding data to series
                pullCaloriesSeries.getData().add(new XYChart.Data<>(eName, totalCalories));
            }
        } catch (SQLException e) {
            // Printing stack trace in case of SQL exception
            e.printStackTrace();
        }
        return pullCaloriesSeries; // Returning series
    }

    // Method to retrieve leg exercise calories burned
    public static XYChart.Series<String, Integer> getLegsCaloriesBurned() {
        XYChart.Series<String, Integer> legsCaloriesSeries = new XYChart.Series<>(); // Creating series for chart
        String sql = "SELECT eName, SUM(caloriesBurned) AS totalCalories FROM Legs GROUP BY eName ORDER BY totalCalories DESC;"; // SQL query

        try (
                Statement statement = connection.createStatement(); // Creating statement object
                ResultSet resultSet = statement.executeQuery(sql) // Executing query
        ) {
            // Iterating through result set
            while (resultSet.next()) {
                String eName = resultSet.getString("eName"); // Retrieving exercise name
                int totalCalories = resultSet.getInt("totalCalories"); // Retrieving total calories burned
                // Adding data to series
                legsCaloriesSeries.getData().add(new XYChart.Data<>(eName, totalCalories));
            }
        } catch (SQLException e) {
            // Printing stack trace in case of SQL exception
            e.printStackTrace();
        }
        return legsCaloriesSeries; // Returning series
    }

    // Method to retrieve push exercises
    public static List<Push> getPushExercises() {
        List<Push> exercises = new ArrayList<>(); // Creating list for exercises
        String sql = "SELECT eID, eName, caloriesBurned FROM Push;"; // SQL query

        try (
                Statement statement = connection.createStatement(); // Creating statement object
                ResultSet resultSet = statement.executeQuery(sql) // Executing query
        ) {
            // Iterating through result set
            while (resultSet.next()) {
                int eID = resultSet.getInt("eID"); // Retrieving exercise ID
                String eName = resultSet.getString("eName"); // Retrieving exercise name
                int caloriesBurned = resultSet.getInt("caloriesBurned"); // Retrieving calories burned
                // Adding exercise to list
                exercises.add(new Push(eID, eName, caloriesBurned));
            }
        } catch (SQLException e) {
            // Printing stack trace in case of SQL exception
            e.printStackTrace();
        }
        return exercises; // Returning list of push exercises
    }

    // Method to retrieve pull exercises
    public static List<Pull> getPullExercises() {
        List<Pull> exercises = new ArrayList<>(); // Creating list for exercises
        String sql = "SELECT eID, eName, caloriesBurned FROM Pull;"; // SQL query

        try (
                Statement statement = connection.createStatement(); // Creating statement object
                ResultSet resultSet = statement.executeQuery(sql) // Executing query
        ) {
            // Iterating through result set
            while (resultSet.next()) {
                int eID = resultSet.getInt("eID"); // Retrieving exercise ID
                String eName = resultSet.getString("eName"); // Retrieving exercise name
                int caloriesBurned = resultSet.getInt("caloriesBurned"); // Retrieving calories burned
                // Adding exercise to list
                exercises.add(new Pull(eID, eName, caloriesBurned));
            }
        } catch (SQLException e) {
            // Printing stack trace in case of SQL exception
            e.printStackTrace();
        }
        return exercises; // Returning list of pull exercises
    }

    // Method to retrieve leg exercises
    public static List<Legs> getLegsExercises() {
        List<Legs> exercises = new ArrayList<>(); // Creating list for exercises
        String sql = "SELECT eID, eName, caloriesBurned FROM Legs;"; // SQL query

        try (
                Statement statement = connection.createStatement(); // Creating statement object
                ResultSet resultSet = statement.executeQuery(sql) // Executing query
        ) {
            // Iterating through result set
            while (resultSet.next()) {
                int eID = resultSet.getInt("eID"); // Retrieving exercise ID
                String eName = resultSet.getString("eName"); // Retrieving exercise name
                int caloriesBurned = resultSet.getInt("caloriesBurned"); // Retrieving calories burned
                // Adding exercise to list
                exercises.add(new Legs(eID, eName, caloriesBurned));
            }
        } catch (SQLException e) {
            // Printing stack trace in case of SQL exception
            e.printStackTrace();
        }
        return exercises; // Returning list of leg exercises
    }
}
