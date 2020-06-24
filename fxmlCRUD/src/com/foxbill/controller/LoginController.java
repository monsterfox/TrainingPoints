package com.foxbill.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
            Parent parent = FXMLLoader.load(getClass().getResource("../view/addressList.fxml"));
            //准备数据


            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            //stage.hide();
            stage.setTitle("主页列表");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }else{
            actiontarget.setText("用户名或密码错误！");
        }

    }
}
