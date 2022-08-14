package com.example.javafxdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField txtusername;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private Button btnlogin;

    @FXML
    void auth(ActionEvent event) {
        if(txtusername.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            String msg ="Username field can not be blank";
            alert.setHeaderText(msg);
            alert.show();
            txtusername.requestFocus();
        }else if(txtpassword.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            String msg ="Password field can not be blank";
            alert.setHeaderText(msg);
            alert.show();
            txtpassword.requestFocus();
        }else {
            String username=txtusername.getText();
            String password=txtpassword.getText();
            if(username.equals("admin") && password.equals("admin123")){
                dashboard();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                String msg ="Invalid Username or Password";
                alert.setHeaderText(msg);
                alert.show();
                txtpassword.requestFocus();
            }
        }

    }

    void dashboard() {
        try {
            final Stage stage=new Stage();
            //stage.initModality(Modality.APPLICATION_MODAL);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("contacts.fxml"));
            Parent root= null;
            root = fxmlLoader.load();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            Stage ss=(Stage) btnlogin.getScene().getWindow();
            ss.close();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
