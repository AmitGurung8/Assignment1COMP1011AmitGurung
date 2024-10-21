package org.example.fitnessapp;

import javafx.event.ActionEvent; // Importing ActionEvent for handling events
import javafx.fxml.FXMLLoader; // Importing class for loading FXML files
import javafx.scene.Node; // Importing class for UI nodes
import javafx.scene.Scene; // Importing class for creating a scene
import javafx.stage.Stage; // Importing class for the application window (stage)

import java.io.IOException; // Importing class for handling IO exceptions

public class SceneManager {
    // Method to change the scene based on the provided FXML file name
    public static void changeScene(ActionEvent event, String fxmlName) throws IOException {
        // Loading the specified FXML file
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlName));

        // Creating a new scene from the loaded FXML
        Scene scene = new Scene(fxmlLoader.load());

        // Getting the current stage from the event source
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Setting the title of the application window
        stage.setTitle("Fitness Tracker");

        // Setting the new scene for the stage
        stage.setScene(scene);

        // Displaying the updated stage
        stage.show();
    }
}
