package org.example.fitnessapp.Controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ToggleGroup;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.example.fitnessapp.*;

public class TableController {

    @FXML
    private RadioButton Legsid;

    @FXML
    private RadioButton Pullid;

    @FXML
    private RadioButton Pushid;

    @FXML
    private TableView<Exercise> tableView; // Use common interface

    @FXML
    private TableColumn<Exercise, Integer> exerciseIdColumn;

    @FXML
    private TableColumn<Exercise, String> exerciseNameColumn;

    @FXML
    private TableColumn<Exercise, Integer> caloriesBurnedColumn;

    private ToggleGroup toggleGroup;

    @FXML
    void initialize() {
        exerciseIdColumn.setCellValueFactory(new PropertyValueFactory<>("eID"));
        exerciseNameColumn.setCellValueFactory(new PropertyValueFactory<>("eName"));
        caloriesBurnedColumn.setCellValueFactory(new PropertyValueFactory<>("caloriesBurned"));

        toggleGroup = new ToggleGroup();
        Pushid.setToggleGroup(toggleGroup);
        Pullid.setToggleGroup(toggleGroup);
        Legsid.setToggleGroup(toggleGroup);


        Pushid.setSelected(true);
        loadTableData("push");

        Pushid.setOnAction(this::Pushoa);
        Pullid.setOnAction(this::Pulloa);
        Legsid.setOnAction(this::Legsoa);
    }

    @FXML
    void Legsoa(ActionEvent event) {
        loadTableData("legs");
    }

    @FXML
    void Pulloa(ActionEvent event) {
        loadTableData("pull");
    }

    @FXML
    void Pushoa(ActionEvent event) {
        loadTableData("push");
    }

    private void loadTableData(String category) {
        List<Exercise> exercises = fetchDataFromDatabase(category);
        tableView.getItems().clear();
        tableView.getItems().addAll(exercises);
    }

    private List<Exercise> fetchDataFromDatabase(String category) {
        List<Exercise> exercises = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/fitness";
        String user = "root";
        String password = "amit";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            String query = "SELECT eID, eName, caloriesBurned FROM " + category + ";";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int eID = resultSet.getInt("eID");
                String eName = resultSet.getString("eName");
                int caloriesBurned = resultSet.getInt("caloriesBurned");

                switch (category) {
                    case "push":
                        exercises.add(new Push(eID, eName, caloriesBurned));
                        break;
                    case "pull":
                        exercises.add(new Pull(eID, eName, caloriesBurned));
                        break;
                    case "legs":
                        exercises.add(new Legs(eID, eName, caloriesBurned));
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exercises;
    }

    @FXML
    void ChartView(ActionEvent event) throws IOException {
        System.out.println("Chart button clicked!");
        SceneManager.changeScene(event,"Fit.fxml");
    }
}
