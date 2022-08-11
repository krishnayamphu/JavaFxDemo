package com.example.javafxdemo;

import com.example.javafxdemo.dao.ContactDao;
import com.example.javafxdemo.dbhelpers.ConnectDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.StringTokenizer;

public class ContactController {
    private ObservableList<Contact> contacts;
    @FXML
    private TextField txtid;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtmobile;

    @FXML
    private TableView<Contact> tbl;

    @FXML
    private TableColumn<Contact, Integer> id;

    @FXML
    private TableColumn<Contact, String> name;

    @FXML
    private TableColumn<Contact, String> mobile;

    @FXML
    public void initialize(){
        load();
    }

    @FXML
    void about(ActionEvent event) {

        try {
            final Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("about.fxml"));
            Parent root= null;
            root = fxmlLoader.load();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void load(){
        contacts= FXCollections.observableArrayList(ContactDao.getAllContacts());
        id.setCellValueFactory(new PropertyValueFactory<Contact, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Contact, String>("name"));
        mobile.setCellValueFactory(new PropertyValueFactory<Contact, String>("mobile"));
        tbl.setItems(contacts);
    }

    public void reset(){
        txtid.setText("");
        txtname.setText("");
        txtmobile.setText("");
    }

    public void crateContact(){
        String name=txtname.getText();
        String mobile=txtmobile.getText();
        if(name.equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alert");
            alert.setHeaderText("");
            String s ="Name field can not be blank";
            alert.setContentText(s);
            alert.show();
            txtname.requestFocus();
        }else if(mobile.equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alert");
            alert.setHeaderText("");
            String s ="Mobile field can not be blank";
            alert.setContentText(s);
            alert.show();
            txtmobile.requestFocus();
        }else{
            Contact contact=new Contact();
            contact.setName(name);
            contact.setMobile(mobile);
            ContactDao.addContact(contact);
            reset();
            load();
        }
    }

    @FXML
    void getRowData(MouseEvent event) {
        Contact contact=tbl.getSelectionModel().getSelectedItem();
        txtid.setText(String.valueOf(contact.getId()));
        txtname.setText(contact.getName());
        txtmobile.setText(contact.getMobile());
    }

    @FXML
    void removeContact(ActionEvent event) {

        if(txtid.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alert");
            alert.setHeaderText("");
            String s ="Please select row data first";
            alert.setContentText(s);
            alert.show();
        }else{
            int id=Integer.parseInt(txtid.getText());
            ContactDao.deleteContact(id);
            reset();
            load();
        }

    }

    @FXML
    void updateContact(ActionEvent event) {

        String name=txtname.getText();
        String mobile=txtmobile.getText();
        if(txtid.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alert");
            alert.setHeaderText("");
            String s ="Please select row data first";
            alert.setContentText(s);
            alert.show();
        }
        else if(name.equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alert");
            alert.setHeaderText("");
            String s ="Name field can not be blank";
            alert.setContentText(s);
            alert.show();
            txtname.requestFocus();
        }else if(mobile.equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alert");
            alert.setHeaderText("");
            String s ="Mobile field can not be blank";
            alert.setContentText(s);
            alert.show();
            txtmobile.requestFocus();
        }else{
            int id=Integer.parseInt(txtid.getText());
            Contact contact=new Contact(id,name,mobile);
            ContactDao.updateContact(contact);
            reset();
            load();
        }

    }

}
