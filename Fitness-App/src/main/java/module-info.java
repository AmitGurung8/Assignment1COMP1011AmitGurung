module org.example.fitnessapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.fitnessapp to javafx.fxml;
    exports org.example.fitnessapp;
    exports org.example.fitnessapp.Controllers;
    opens org.example.fitnessapp.Controllers to javafx.fxml;
}