module org.example.lab5ad {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.lab5ad to javafx.fxml;
    exports org.example.lab5ad;
}