package com.foxbill.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    /*
        @FXML注解用于标记由FXML使用的非公开的控制器成员属性和事件处理方法。
     */
    @FXML private TextField textField;
    @FXML private PasswordField passwordField;
    @FXML private Text actiontarget;
    @FXML protected void handleSubmitButtonAction(ActionEvent event) throws IOException {
        String username = textField.getText();
        String password = passwordField.getText();
        if ("1".equals(username) && "1".equals(password)){
            // 通过事件获取Stage对象
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setTitle("主页列表");
            primaryStage.centerOnScreen();
            // Load root layout from fxml file. --
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(LoginController.class.getResource("../view/RootLayout.fxml"));
            BorderPane rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);

            primaryStage.setScene(scene);
            primaryStage.show();

            // Load addressList .  --添加 addressList.fxml 到RootLayout.fxml中去
            FXMLLoader loader1 = new FXMLLoader();
            loader1.setLocation(LoginController.class.getResource("../view/addressList.fxml"));
            AnchorPane addressList = (AnchorPane) loader1.load();

            // Set addressList into the center of root layout.
            rootLayout.setCenter(addressList);

        }else{
            actiontarget.setText("用户名或密码错误！");
        }

    }


}
