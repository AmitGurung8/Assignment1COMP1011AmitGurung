package org.example.fitnessapp;

import org.example.fitnessapp.Utility.DBUtility;
import javafx.application.Application; // Importing JavaFX Application class
import javafx.fxml.FXMLLoader; // Importing class for loading FXML files
import javafx.scene.Scene; // Importing class for creating a scene
import javafx.scene.image.Image; // Importing class for handling images
import javafx.stage.Stage; // Importing class for the application window (stage)
import java.io.IOException; // Importing class for handling IO exceptions

public class Main extends Application {
    public static Stage stage; // Declaring a static stage variable

    // Overriding the start method to set up the application
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage; // Storing the stage reference
        DBUtility.connect(); // Connecting to the database

        // Loading the FXML file for the main layout
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fit.fxml"));
        // Loading the FXML file for the table view
        FXMLLoader fxmlLoader2 = new FXMLLoader(Main.class.getResource("TableView.fxml"));

        // Creating a scene from the loaded FXML
        Scene scene = new Scene(fxmlLoader2.load());

        // Setting the title of the application window
        stage.setTitle("The Fitness Tracker");

        // Adding an icon to the application window
        stage.getIcons().add(new Image(getClass().getResourceAsStream("muscle.png")));

        // Setting the scene for the stage
        stage.setScene(scene);

        // Displaying the application window
        stage.show();
    }

    // Main method to launch the application
    public static void main(String[] args) {
        launch(); // Launching the JavaFX application
    }
}
