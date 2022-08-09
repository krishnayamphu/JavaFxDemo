module com.example.javafxdemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javafxdemo to javafx.fxml;
    exports com.example.javafxdemo;
}