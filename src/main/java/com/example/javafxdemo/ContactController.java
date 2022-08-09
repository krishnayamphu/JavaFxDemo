package com.example.javafxdemo;

import com.example.javafxdemo.dao.ContactDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ContactController {
    private ObservableList<Contact> contacts;

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

    public void load(){
        contacts= FXCollections.observableArrayList(ContactDao.getAllContacts());
        id.setCellValueFactory(new PropertyValueFactory<Contact, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Contact, String>("name"));
        mobile.setCellValueFactory(new PropertyValueFactory<Contact, String>("mobile"));
        tbl.setItems(contacts);
    }

    public void crateContact(){
        String name=txtname.getText();
        String mobile=txtmobile.getText();
        Contact contact=new Contact();
        contact.setName(name);
        contact.setMobile(mobile);
        ContactDao.addContact(contact);
        load();
    }

}
