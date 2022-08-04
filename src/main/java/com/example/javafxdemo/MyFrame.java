package com.example.javafxdemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MyFrame extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane root=new AnchorPane();
        Scene scene=new Scene(root,300,200);
        Button btn=new Button("button");
        root.getChildren().add(btn);
        stage.setScene(scene);
        stage.setTitle("JavaFX Demo");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
