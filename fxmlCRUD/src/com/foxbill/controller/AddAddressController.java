package com.foxbill.controller;

import com.foxbill.data.Container;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.foxbill.domain.Person;

import java.io.IOException;

public class AddAddressController {
    @FXML
    private TextField firstTF,lastTF,emailTF;

    @FXML
    protected void handleSaveAction(ActionEvent event) throws IOException {
        String firstName = firstTF.getText();
        String lastName = lastTF.getText();
        String email = emailTF.getText();

        Person person = new Person(firstName,lastName,email);
        Container.personList.add(person);

        Parent parent = FXMLLoader.load(getClass().getResource("../view/addressList.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //stage.hide();
        stage.setTitle("主页列表");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    protected void handleCancelAction(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/addressList.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //stage.hide();
        stage.setTitle("主页列表");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
