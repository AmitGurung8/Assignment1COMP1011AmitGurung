package org.example.fitnessapp.Controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.BarChart;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import org.example.fitnessapp.Main;
import org.example.fitnessapp.SceneManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Fit implements Initializable {

    @FXML
    private BarChart<String, Integer> BarChartFitness;

    @FXML
    private NumberAxis CaloriesBurned;

    @FXML
    private RadioButton Legse;

    @FXML
    private CategoryAxis Namee;

    @FXML
    private RadioButton Pulle;

    @FXML
    private RadioButton Pushe;

    @FXML
    private ToggleGroup toggleGroup;

    @FXML
    private Button TableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        toggleGroup = new ToggleGroup();

        Pushe.setToggleGroup(toggleGroup);
        Pulle.setToggleGroup(toggleGroup);
        Legse.setToggleGroup(toggleGroup);


        Pushe.setOnAction(this::PushAction);
        Pulle.setOnAction(this::PullAction);
        Legse.setOnAction(this::LegsAction);


        Pushe.setSelected(true);
        updateChartForPush();
    }

    @FXML
    void LegsAction(ActionEvent event) {
        updateChartForLegs();
    }

    @FXML
    void PullAction(ActionEvent event) {
        updateChartForPull();
    }

    @FXML
    void PushAction(ActionEvent event) {
        updateChartForPush();
    }

    @FXML
    void TableView(ActionEvent event) throws IOException {
        System.out.println("Table button clicked!");
        SceneManager.changeScene(event,"TableView.fxml");
    }

    private void updateChartForPush() {
        BarChartFitness.getData().clear();
        BarChartFitness.getData().add(org.example.fitnessapp.DBUtility.getPushCaloriesBurned());
        Namee.setLabel("Push Exercises");
    }

    private void updateChartForPull() {
        BarChartFitness.getData().clear();
        BarChartFitness.getData().add(org.example.fitnessapp.DBUtility.getPullCaloriesBurned());
        Namee.setLabel("Pull Exercises");
    }

    private void updateChartForLegs() {
        BarChartFitness.getData().clear();
        BarChartFitness.getData().add(org.example.fitnessapp.DBUtility.getLegsCaloriesBurned());
        Namee.setLabel("Leg Exercises");
    }
}
