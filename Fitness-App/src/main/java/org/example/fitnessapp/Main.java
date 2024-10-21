package org.example.fitnessapp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;


public class Main extends Application {
    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        DBUtility.connect();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fit.fxml"));
        FXMLLoader fxmlLoader2 = new FXMLLoader(Main.class.getResource("TableView.fxml"));
        Scene scene = new Scene(fxmlLoader2.load());
        stage.setTitle("The Fitness Tracker");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("muscle.png")));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}