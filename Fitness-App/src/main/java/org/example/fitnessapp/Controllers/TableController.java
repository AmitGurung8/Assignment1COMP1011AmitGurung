package org.example.fitnessapp.Controllers;

import javafx.event.ActionEvent; // Importing class for handling action events
import javafx.fxml.FXML; // Importing FXML for annotating UI elements
import javafx.scene.control.RadioButton; // Importing class for radio buttons
import javafx.scene.control.TableColumn; // Importing class for table columns
import javafx.scene.control.TableView; // Importing class for table view
import javafx.scene.control.cell.PropertyValueFactory; // Importing class for cell value factories
import javafx.scene.control.ToggleGroup; // Importing class for grouping radio buttons
import java.io.IOException; // Importing class for handling IO exceptions
import java.sql.Connection; // Importing class for database connections
import java.sql.DriverManager; // Importing class for managing database drivers
import java.sql.ResultSet; // Importing class for handling result sets
import java.sql.Statement; // Importing class for SQL statements
import java.util.ArrayList; // Importing class for dynamic arrays
import java.util.List; // Importing class for lists
import org.example.fitnessapp.*; // Importing all classes from the fitness app package
import org.example.fitnessapp.Models.Exercise;
import org.example.fitnessapp.Models.Legs;
import org.example.fitnessapp.Models.Pull;
import org.example.fitnessapp.Models.Push;

public class TableController {

    @FXML
    private RadioButton Legsid; // Radio button for legs exercises

    @FXML
    private RadioButton Pullid; // Radio button for pull exercises

    @FXML
    private RadioButton Pushid; // Radio button for push exercises

    @FXML
    private TableView<Exercise> tableView; // Table view for displaying exercises

    @FXML
    private TableColumn<Exercise, Integer> exerciseIdColumn; // Column for exercise ID

    @FXML
    private TableColumn<Exercise, String> exerciseNameColumn; // Column for exercise name

    @FXML
    private TableColumn<Exercise, Integer> caloriesBurnedColumn; // Column for calories burned

    private ToggleGroup toggleGroup; // Group for managing radio buttons

    // Initialize method called after FXML is loaded
    @FXML
    void initialize() {
        // Setting up the cell value factories for the table columns
        exerciseIdColumn.setCellValueFactory(new PropertyValueFactory<>("eID"));
        exerciseNameColumn.setCellValueFactory(new PropertyValueFactory<>("eName"));
        caloriesBurnedColumn.setCellValueFactory(new PropertyValueFactory<>("caloriesBurned"));

        // Initializing toggle group for radio buttons
        toggleGroup = new ToggleGroup();
        Pushid.setToggleGroup(toggleGroup);
        Pullid.setToggleGroup(toggleGroup);
        Legsid.setToggleGroup(toggleGroup);

        // Setting the default selected radio button and loading initial data
        Pushid.setSelected(true);
        loadTableData("push");

        // Setting action listeners for radio buttons
        Pushid.setOnAction(this::Pushoa);
        Pullid.setOnAction(this::Pulloa);
        Legsid.setOnAction(this::Legsoa);
    }

    // Action method for legs radio button
    @FXML
    void Legsoa(ActionEvent event) {
        loadTableData("legs"); // Loading data for legs exercises
    }

    // Action method for pull radio button
    @FXML
    void Pulloa(ActionEvent event) {
        loadTableData("pull"); // Loading data for pull exercises
    }

    // Action method for push radio button
    @FXML
    void Pushoa(ActionEvent event) {
        loadTableData("push"); // Loading data for push exercises
    }

    // Method to load table data based on selected exercise category
    private void loadTableData(String category) {
        List<Exercise> exercises = fetchDataFromDatabase(category); // Fetching data from database
        tableView.getItems().clear(); // Clearing existing items in the table
        tableView.getItems().addAll(exercises); // Adding new items to the table
    }

    // Method to fetch data from the database based on the selected category
    private List<Exercise> fetchDataFromDatabase(String category) {
        List<Exercise> exercises = new ArrayList<>(); // List to hold exercises
        String url = "jdbc:mysql://localhost:3306/fitness"; // Database URL
        String user = "root"; // Database username
        String password = "amit"; // Database password

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            // SQL query to fetch exercises based on the category
            String query = "SELECT eID, eName, caloriesBurned FROM " + category + ";";
            ResultSet resultSet = statement.executeQuery(query);
            // Iterating through the result set and adding exercises to the list
            while (resultSet.next()) {
                int eID = resultSet.getInt("eID");
                String eName = resultSet.getString("eName");
                int caloriesBurned = resultSet.getInt("caloriesBurned");

                switch (category) {
                    case "push":
                        exercises.add(new Push(eID, eName, caloriesBurned)); // Adding Push exercise
                        break;
                    case "pull":
                        exercises.add(new Pull(eID, eName, caloriesBurned)); // Adding Pull exercise
                        break;
                    case "legs":
                        exercises.add(new Legs(eID, eName, caloriesBurned)); // Adding Legs exercise
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Printing stack trace in case of exceptions
        }
        return exercises; // Returning the list of exercises
    }

    // Action method for chart view button
    @FXML
    void ChartView(ActionEvent event) throws IOException {
        System.out.println("Chart button clicked!"); // Logging button click
        SceneManager.changeScene(event, "Fit.fxml"); // Changing to chart view scene
    }
}
