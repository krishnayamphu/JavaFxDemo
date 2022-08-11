package com.example.javafxdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AboutController {
    @FXML
    private Button btnClose;
    @FXML
    void hideWindow(ActionEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
}
