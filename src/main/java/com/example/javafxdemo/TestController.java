package com.example.javafxdemo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TestController {

    @FXML
    private Button btn;

    @FXML
    private TextField txtbox;

    @FXML
    public void initialize() {
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Hello World");
                txtbox.setText("Hello world");
            }
        });
        System.out.println("running test fxml window");
    }

    @FXML
    void hello(ActionEvent event) {
        System.out.println("hello there!");
    }
}