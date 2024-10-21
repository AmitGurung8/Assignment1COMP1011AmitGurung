module org.example.fitnessapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.fitnessapp to javafx.fxml;
    exports org.example.fitnessapp;
    exports org.example.fitnessapp.Controllers;
    opens org.example.fitnessapp.Controllers to javafx.fxml;
    exports org.example.fitnessapp.Models;
    opens org.example.fitnessapp.Models to javafx.fxml;
    exports org.example.fitnessapp.Utility;
    opens org.example.fitnessapp.Utility to javafx.fxml;
}