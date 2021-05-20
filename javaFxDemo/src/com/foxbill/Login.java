package com.foxbill;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/login.fxml"));
        primaryStage.setTitle("登录");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.centerOnScreen();//设置窗口居中（窗口会闪烁）
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
