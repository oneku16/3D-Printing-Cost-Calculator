package com.example.calculator_2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;

import java.io.IOException;

public class Home extends  Application{
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("home_page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 420);
//        stage.setRoot(fxmlLoader);
        stage.setTitle("Version 3.3");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch();
    }
}