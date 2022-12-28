package com.example.calculator_2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("home_page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 420);
        stage.setTitle("Version 3.3");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch();
    }
}