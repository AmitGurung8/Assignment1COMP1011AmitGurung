package org.example.fitnessapp;
import javafx.scene.chart.XYChart;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {
    private static String user = "root";
    private static String password = "amit";
    private static String connectURL = "jdbc:mysql://localhost:3306/fitness";
    private static Connection connection;

    public static void connect() {
        try {
            connection = DriverManager.getConnection(connectURL, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
    }}

        public static XYChart.Series<String, Integer> getPushCaloriesBurned() {
            XYChart.Series<String, Integer> pushCaloriesSeries = new XYChart.Series<>();
            String sql = "SELECT eName, SUM(caloriesBurned) AS totalCalories FROM Push GROUP BY eName ORDER BY totalCalories DESC;";

            try (
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql)
            ) {
                while (resultSet.next()) {
                    String eName = resultSet.getString("eName");
                    int totalCalories = resultSet.getInt("totalCalories");
                    pushCaloriesSeries.getData().add(new XYChart.Data<>(eName, totalCalories));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return pushCaloriesSeries;
        }

    public static XYChart.Series<String, Integer> getPullCaloriesBurned() {
        XYChart.Series<String, Integer> pullCaloriesSeries = new XYChart.Series<>();
        String sql = "SELECT eName, SUM(caloriesBurned) AS totalCalories FROM Pull GROUP BY eName ORDER BY totalCalories DESC;";

        try (
              Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {
            while (resultSet.next()) {
                String eName = resultSet.getString("eName");
                int totalCalories = resultSet.getInt("totalCalories");
                pullCaloriesSeries.getData().add(new XYChart.Data<>(eName, totalCalories));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pullCaloriesSeries;
    }

    public static XYChart.Series<String, Integer> getLegsCaloriesBurned() {
        XYChart.Series<String, Integer> legsCaloriesSeries = new XYChart.Series<>();
        String sql = "SELECT eName, SUM(caloriesBurned) AS totalCalories FROM Legs GROUP BY eName ORDER BY totalCalories DESC;";

        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {
            while (resultSet.next()) {
                String eName = resultSet.getString("eName");
                int totalCalories = resultSet.getInt("totalCalories");
                legsCaloriesSeries.getData().add(new XYChart.Data<>(eName, totalCalories));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return legsCaloriesSeries;
    }

    public static List<Push> getPushExercises() {
        List<Push> exercises = new ArrayList<>();
        String sql = "SELECT eID, eName, caloriesBurned FROM Push;";

        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {
            while (resultSet.next()) {
                int eID = resultSet.getInt("eID");
                String eName = resultSet.getString("eName");
                int caloriesBurned = resultSet.getInt("caloriesBurned");
                exercises.add(new Push(eID, eName, caloriesBurned));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exercises;
    }

    public static List<Pull> getPullExercises() {
        List<Pull> exercises = new ArrayList<>();
        String sql = "SELECT eID, eName, caloriesBurned FROM Pull;";

        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {
            while (resultSet.next()) {
                int eID = resultSet.getInt("eID");
                String eName = resultSet.getString("eName");
                int caloriesBurned = resultSet.getInt("caloriesBurned");
                exercises.add(new Pull(eID, eName, caloriesBurned));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exercises;
    }

    public static List<Legs> getLegsExercises() {
        List<Legs> exercises = new ArrayList<>();
        String sql = "SELECT eID, eName, caloriesBurned FROM Legs;";

        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {
            while (resultSet.next()) {
                int eID = resultSet.getInt("eID");
                String eName = resultSet.getString("eName");
                int caloriesBurned = resultSet.getInt("caloriesBurned");
                exercises.add(new Legs(eID, eName, caloriesBurned));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exercises;
    }
}
