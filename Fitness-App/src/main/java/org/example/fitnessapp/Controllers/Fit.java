package org.example.fitnessapp.Controllers;

import javafx.fxml.FXML; // Importing FXML for annotating UI elements
import javafx.fxml.FXMLLoader; // Importing class for loading FXML files
import javafx.fxml.Initializable; // Importing interface for initializing controllers
import javafx.scene.Scene; // Importing class for creating a scene
import javafx.scene.chart.CategoryAxis; // Importing class for category axis in charts
import javafx.scene.chart.NumberAxis; // Importing class for number axis in charts
import javafx.scene.chart.BarChart; // Importing class for bar charts
import javafx.scene.control.RadioButton; // Importing class for radio buttons
import javafx.scene.control.ToggleGroup; // Importing class for grouping radio buttons
import javafx.event.ActionEvent; // Importing class for handling action events
import javafx.scene.control.Button; // Importing class for buttons
import org.example.fitnessapp.SceneManager; // Importing SceneManager for scene navigation

import java.io.IOException; // Importing class for handling IO exceptions
import java.net.URL; // Importing class for URL handling
import java.util.ResourceBundle; // Importing class for resource bundles

public class Fit implements Initializable {

    @FXML
    private BarChart<String, Integer> BarChartFitness; // Bar chart for displaying fitness data

    @FXML
    private NumberAxis CaloriesBurned; // Axis for calories burned

    @FXML
    private RadioButton Legse; // Radio button for legs exercises

    @FXML
    private CategoryAxis Namee; // Axis for exercise names

    @FXML
    private RadioButton Pulle; // Radio button for pull exercises

    @FXML
    private RadioButton Pushe; // Radio button for push exercises

    @FXML
    private ToggleGroup toggleGroup; // Group for managing radio buttons

    @FXML
    private Button TableView; // Button to navigate to table view

    // Initialize method called after FXML is loaded
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        toggleGroup = new ToggleGroup(); // Initializing toggle group

        // Adding radio buttons to the toggle group
        Pushe.setToggleGroup(toggleGroup);
        Pulle.setToggleGroup(toggleGroup);
        Legse.setToggleGroup(toggleGroup);

        // Setting action listeners for radio buttons
        Pushe.setOnAction(this::PushAction);
        Pulle.setOnAction(this::PullAction);
        Legse.setOnAction(this::LegsAction);

        // Setting default selected radio button
        Pushe.setSelected(true);
        updateChartForPush(); // Updating chart for push exercises
    }

    // Action method for legs radio button
    @FXML
    void LegsAction(ActionEvent event) {
        updateChartForLegs(); // Updating chart for legs exercises
    }

    // Action method for pull radio button
    @FXML
    void PullAction(ActionEvent event) {
        updateChartForPull(); // Updating chart for pull exercises
    }

    // Action method for push radio button
    @FXML
    void PushAction(ActionEvent event) {
        updateChartForPush(); // Updating chart for push exercises
    }

    // Action method for table view button
    @FXML
    void TableView(ActionEvent event) throws IOException {
        System.out.println("Table button clicked!"); // Logging button click
        SceneManager.changeScene(event, "TableView.fxml"); // Changing to table view scene
    }

    // Method to update the chart for push exercises
    private void updateChartForPush() {
        BarChartFitness.getData().clear(); // Clearing existing data
        BarChartFitness.getData().add(org.example.fitnessapp.DBUtility.getPushCaloriesBurned()); // Adding new data
        Namee.setLabel("Push Exercises"); // Setting axis label
    }

    // Method to update the chart for pull exercises
    private void updateChartForPull() {
        BarChartFitness.getData().clear(); // Clearing existing data
        BarChartFitness.getData().add(org.example.fitnessapp.DBUtility.getPullCaloriesBurned()); // Adding new data
        Namee.setLabel("Pull Exercises"); // Setting axis label
    }

    // Method to update the chart for legs exercises
    private void updateChartForLegs() {
        BarChartFitness.getData().clear(); // Clearing existing data
        BarChartFitness.getData().add(org.example.fitnessapp.DBUtility.getLegsCaloriesBurned()); // Adding new data
        Namee.setLabel("Leg Exercises"); // Setting axis label
    }
}
